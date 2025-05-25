/**
 * ICartRepository.java
 * Author: [Mnelisi Mabona]
 * Student Number: [2222062088]
 * Date: [25 May 2025]
 *
 * This interface handles all database operations for the Cart entity.
 */

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Cart;

import java.util.Optional;

public interface ICartRepository extends JpaRepository<Cart, String> {


    Optional<Cart> findByCartId(String cartId);


}