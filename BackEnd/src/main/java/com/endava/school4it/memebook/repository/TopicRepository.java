package com.endava.school4it.memebook.repository;

import com.endava.school4it.memebook.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
}
