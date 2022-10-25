package ru.hogwarts.school1.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.hogwarts.school1.model.Avatar;

import java.util.List;
import java.util.Optional;

@Repository
    public interface AvatarRepository extends PagingAndSortingRepository<Avatar, Long> {

        Optional<Avatar> findByStudentId(Long studentId);

         List<Avatar> findAll();
}
