package vn.tungnt.demo;

/*
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0")
public class ShoppingApplicationTest {

	@Value("${local.server.port}")
	private int port;
//	@Value("${local.server.context-path}")
	private String context = "";
	
	// @Autowired
	// private CustomerResource customerResource;

	private TestRestTemplate restTemplate;

	private String urlStr;
	private String xml;

	@Before
	public void setup() {
		urlStr = "http://localhost:" + port + "/" + context + "services/customers";

		restTemplate = new TestRestTemplate();

		xml = "<customer>"
                + "<first-name>Bill</first-name>"
                + "<last-name>Burke</last-name>"
                + "<street>256 Clarendon Street</street>"
                + "<city>Boston</city>"
                + "<state>MA</state>"
                + "<zip>02115</zip>"
                + "<country>USA</country>"
                + "</customer>";
	}

	@Test
	public void testCustomer() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		headers.setContentType(MediaType.APPLICATION_XML);

		HttpEntity<String> httpEntity = new HttpEntity<String>(this.xml, headers);

		ResponseEntity<String> response = restTemplate.postForEntity(this.urlStr, httpEntity, String.class);
		Assert.assertNotNull(response);
		Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());

		String urlForGetById = this.urlStr + "/1";
		response = restTemplate.getForEntity(urlForGetById, String.class);

		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());

		String xmlData = response.getBody();
		System.out.println("xmlData: " + xmlData);
		
		InputStream is = new ByteArrayInputStream(xmlData.getBytes());

		CustomerResource cr = new CustomerResource();
		Customer customer = cr.readCustomer(is);

		Assert.assertEquals("Bill", customer.getFirstName());
	}

}
*/