package com.sonan.booklibrary.repository;

import com.sonan.booklibrary.model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * UserDetail을 보유한 repository
 *
 * Created by Jaeseong on 2020/07/26
 * Git Hub : https://github.com/AnJaeSeongS2
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {
    List<Reader> findByUsername(String username);
}
