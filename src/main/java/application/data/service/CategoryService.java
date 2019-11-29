package application.data.service;

import application.data.model.Category;
import application.data.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryService {

    @Autowired CategoryRepository categoryRepository;

    @Transactional
        public long getTotalCategories() {
            return categoryRepository.getTotalCategories();
        }

}
