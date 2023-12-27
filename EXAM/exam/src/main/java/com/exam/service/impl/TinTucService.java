package com.exam.service.impl;

import com.exam.mode.TinTuc;
import com.exam.repository.ITinTucRepository;
import com.exam.service.ITinTucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TinTucService implements ITinTucService {
    @Autowired
    private ITinTucRepository tinTucRepository;

    @Override
    public Page<TinTuc> danhSachTinTuc(Pageable pageable) {
        return this.tinTucRepository.findALl(pageable);
    }

    @Transactional
    @Override
    public void add(TinTuc tinTuc) {
        try {
            this.tinTucRepository.save(tinTuc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        TinTuc tinTuc = findById(id);
        if (tinTuc != null) {
            this.tinTucRepository.delete(tinTuc);
        }
    }

    @Override
    public TinTuc findById(int id) {
        return this.tinTucRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
