package edu.school21.chat.repository;

import edu.school21.chat.models.Message;

import java.util.Optional;

public interface MessagesRepositoryJdbc {

    Optional<Message> findById(Long id);

    void save(Message message);
}
