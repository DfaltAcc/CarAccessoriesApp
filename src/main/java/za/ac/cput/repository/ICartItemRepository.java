/**
 * ICartItemRepository.java
 * Author: [Mnelisi Mabona]
 * Student Number: [222062088]
 * Date: [25 May 2025]
 *
 * This interface provides JPA functionality for CartItem entity including CRUD operations.
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.CartItem;

import java.util.Optional;

public interface ICartItemRepository extends JpaRepository<CartItem, String> {

    Optional<CartItem> findByCartItemId(String cartItemId);

}