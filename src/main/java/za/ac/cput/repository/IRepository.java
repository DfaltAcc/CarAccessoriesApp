/* IRepository.java
   Author: Hlumelo Madlingozi
   Date: 05 May 2025
*/

package za.ac.cput.repository;

import java.util.Set;

public interface IRepository<T, ID> {
    T create(T t);
    T read(ID id);
    T update(T t);
    boolean delete(ID id);
    Set<T> getAll();
}