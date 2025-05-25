package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Admin;
import za.ac.cput.repository.AdminRepository;

import java.util.List;
import java.util.Optional;
@Service
public class AdminService implements IAdminService {
    private AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin findByName(String name) {
        return adminRepository.findByName(name);
    }

    @Override
    public Optional<Admin> findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public List<Admin> findAllByUserID(String userID) {
        return List.of();
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Optional<Admin> read(String adminID) {
        return adminRepository.findById(adminID);
    }

    @Override
    public Admin update(Admin admin) {
        if(adminRepository.existsById(admin.getAdminID())) {
            return adminRepository.save(admin);
        }
        return null;
    }
}
