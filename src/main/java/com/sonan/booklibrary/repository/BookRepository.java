package com.sonan.booklibrary.repository;

import com.sonan.booklibrary.model.Book;
import com.sonan.booklibrary.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * JpaRepository를 확장한 인터페이스는, 메서드를 정의만 해놔도, 런타임에 정의대로 구현된다.
 * Created by Jaeseong on 2020/07/24
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(Reader reader);
}
