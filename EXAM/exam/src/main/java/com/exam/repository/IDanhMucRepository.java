package com.exam.repository;

import com.exam.mode.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDanhMucRepository extends JpaRepository<DanhMuc, Integer> {
}
