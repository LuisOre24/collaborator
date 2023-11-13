package com.devloc.managementsof;

import com.devloc.managementsof.entity.*;
import com.devloc.managementsof.repository.IUserAccessRepo;
import com.devloc.managementsof.service.*;
import com.devloc.managementsof.service.impl.UserAccessServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class ManagementsofApplicationTests {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserAccessServiceImpl userAccessService;

	@Autowired
	private ICompanyService companyService;
	@Autowired
	private ISubsidiaryService subsidiaryService;
	@Autowired
	private IDocumentService documentService;
	@Autowired
	private IEmployeeService employeeService;
	@Autowired
	private IWorkAreaService workAreaService;
	@Autowired
	private IRolService rolService;
	@Autowired
	private IPositionService positionService;
	@Test
	void contextLoads() {

		/*Company company = new Company();
		company.setCodCompany("CO001");
		company.setNameCompany("ENTERPRISE ABC");
		company.setRucCompany("11232132100");
		company.setAddress("AV. CAMINOS DE LA VIDA 123");
		company.setStatus(true);


		Company companyTest = companyService.create(company);
		assertThat(companyTest.getCodCompany().equals(company.getCodCompany()));

		assert companyTest.getCodCompany().equals(company.getCodCompany());

		Document document = new Document();
		WorkArea workArea = new WorkArea();
		Subsidiary subsidiary = new Subsidiary();
		Position position = new Position();
		document = documentService.getOneById(1);
		workArea = workAreaService.getOneById(1);
		subsidiary = subsidiaryService.getOneById(1);
		position = positionService.getOneById(1);

		Employee employee = new Employee();
		employee.setName("LUIS");
		employee.setSecondName("ENRIQUE");
		employee.setLastname("ORE");
		employee.setSecondLastname("CARDENAS");
		employee.setDocument(document);
		employee.setNumberDocument("74150936");
		employee.setWorkArea(workArea);
		employee.setSubsidiary(subsidiary);
		employee.setPosition(position);

		Employee employeeTest = employeeService.create(employee);

		assert employeeTest.getNumberDocument().equals(employee.getNumberDocument());*/


		UserAccess userAccess = new UserAccess();

		Employee employee = new Employee();
		employee = employeeService.getOneById(1);

		Collection<Rol> roles = new ArrayList<Rol>();
		roles.add(rolService.getOneById(1));

		userAccess.setEmployee(employee);
		userAccess.setUsername("LORE");
		userAccess.setPassword("leoc.1996$");
		userAccess.setRoles(roles);

		UserAccess userAccessTest = userAccessService.create(userAccess);
		//UserAccess userAccessTest = userAccessService.getOneById(1);

		assert userAccessTest.getUsername().equals(userAccess.getUsername());

		/*UserDetails user = userAccessService.loadUserByUsername("LORE");
		System.out.println(user);*/


	}

}
