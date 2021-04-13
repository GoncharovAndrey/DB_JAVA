package edu.school21.chat.repository;

import edu.school21.chat.exception.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import static edu.school21.chat.models.ColumnName.*;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepositoryJdbc {

    private final DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) {
        String getMessageById = "SELECT m.message_id, m.text, m.message_date, u.user_id ,u.login, u.password, c.chat_id, chat_name FROM messages m"
                + " LEFT JOIN users u on u.user_id = m.message_author"
                + " LEFT JOIN chatrooms c on m.message_room = c.chat_id"
                + " WHERE m.message_id = ?";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;
        Message message = null;

        try {
            con = dataSource.getConnection();
            pst = con.prepareStatement(getMessageById);
            pst.setLong(1, id);
            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                Long messageId = resultSet.getLong(MESSAGE_ID);
                String messageText = resultSet.getString(MESSAGE_TEXT);
                Timestamp date = new Timestamp(resultSet.getDate(MESSAGE_DATE).getTime());
                Long userId = resultSet.getLong(USER_ID);
                String userLogin = resultSet.getString(USER_LOGIN);
                String userPassword = resultSet.getString(USER_PASSWORD);
                Long chatId = resultSet.getLong(CHAT_ID);
                String chatName = resultSet.getString(CHAT_NAME);
                User user = new User(userId, userLogin, userPassword);
                Chatroom chatRoom = new Chatroom(chatId, chatName, user);
                message = new Message(messageId, user, chatRoom, messageText, date);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return Optional.ofNullable(message);
    }

    @Override
    public void save(Message message) {
        String saveMessage = "insert into messages (message_id, text , message_author, message_room, message_date) VALUES (default , ?, ?, ?, default );";
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet resultSet = null;

        try {
            pst = dataSource.getConnection().prepareStatement(saveMessage, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, message.getText());
            pst.setLong(2, message.getAuthor().getId());
            pst.setLong(3, message.getChatroom().getId());

            pst.execute();
            resultSet = pst.getGeneratedKeys();
            resultSet.next();
            message.setId(resultSet.getLong(MESSAGE_ID));
            message.setCreationDate(resultSet.getTimestamp(MESSAGE_DATE));
            pst.close();
        } catch (SQLException e) {
            throw new NotSavedSubEntityException("Not Saved Entity", e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    con.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
