package de.stockexchange.stocks.persistance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DateRepository extends JpaRepository<DateEntity, Long> {
}
