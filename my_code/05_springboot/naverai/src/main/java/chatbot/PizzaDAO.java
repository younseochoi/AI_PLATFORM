package chatbot;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("pizzadao")
public interface PizzaDAO {

	public int orderPizza(PizzaDTO dto);
}
