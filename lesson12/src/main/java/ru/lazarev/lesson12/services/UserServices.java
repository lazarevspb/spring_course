package ru.lazarev.lesson12.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.lazarev.lesson12.dto.ProductDto;
import ru.lazarev.lesson12.exceprion_handling.ResourceNotFoundException;
import ru.lazarev.lesson12.model.Product;
import ru.lazarev.lesson12.model.User;
import ru.lazarev.lesson12.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository repository;

    public Optional<User> findProductById(Long id) {
        return repository.findById(id);
    }

    public List<User> findAllProduct() {
        return repository.findAll();
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User saveOrUpdate(User user) {
        return repository.save(user);
    }

    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
