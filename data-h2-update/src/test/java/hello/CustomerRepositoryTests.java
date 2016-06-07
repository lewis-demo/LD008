package hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class CustomerRepositoryTests {

	private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryTests.class);

	@Autowired
	private CustomerRepository customerRepo;

	@Test
	public void save() {
		logger.debug("save()...");
		long count = this.customerRepo.findAll().size();

		Customer obj = new Customer("Lu", "Lewis");
		this.customerRepo.save(obj);

		assertEquals(count + 1, this.customerRepo.findAll().size());
	}

	@Test
	public void deleteAll() {
		logger.debug("deleteAll()...");
		this.customerRepo.deleteAll();
		assertEquals(0, this.customerRepo.findAll().size());
	}
}
