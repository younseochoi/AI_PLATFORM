package chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pizzaservice")
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	PizzaDAO dao;
	
	@Override
	public int orderPizza(PizzaDTO dto) {
		return dao.orderPizza(dto);
	}

}
