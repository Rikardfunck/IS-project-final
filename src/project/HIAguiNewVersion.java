package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class HIAguiNewVersion {

	private JFrame frame;
	private JTextField textField_kundNummer;
	private JTextField textField_kundNamn;
	private JTextField textField_adress;
	private JTextField textField_produktNamn;
	private JTextField textField_kategori;
	private JTextField textField_pris;
	private JTextField textField_serieNummer;
	private JTextField textField_orderNummer;
	private JTextField textField_leveransDatum;
	private JTextField textField_orderRadsNummer;
	private JTextArea textArea;
	private JButton btnSkExemplar;
	private JLabel lblOrderrad; 
	private JButton btnTaBortOrderrad;
	private Controller controller = new Controller();
	private JTextField textField_kvantitet;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HIAguiNewVersion window = new HIAguiNewVersion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HIAguiNewVersion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBounds(100, 100, 833, 556);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		textField_kundNummer = new JTextField();
		textField_kundNummer.setBounds(123, 28, 116, 22);
		frame.getContentPane().add(textField_kundNummer);
		textField_kundNummer.setColumns(10);
		
		textField_kundNamn = new JTextField();
		textField_kundNamn.setBounds(123, 63, 116, 22);
		frame.getContentPane().add(textField_kundNamn);
		textField_kundNamn.setColumns(10);
		
		textField_adress = new JTextField();
		textField_adress.setBounds(123, 98, 116, 22);
		frame.getContentPane().add(textField_adress);
		textField_adress.setColumns(10);
		
		JLabel lblKundnummer = new JLabel("Kundnummer");
		lblKundnummer.setBounds(12, 31, 89, 16);
		frame.getContentPane().add(lblKundnummer);
		
		JLabel lblNamn = new JLabel("Namn");
		lblNamn.setBounds(12, 66, 56, 16);
		frame.getContentPane().add(lblNamn);
		
		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setBounds(12, 101, 56, 16);
		frame.getContentPane().add(lblAdress);
		
		JButton btnSkapaKund = new JButton("Skapa kund");
		btnSkapaKund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String customerNbr = textField_kundNummer.getText();
				String name = textField_kundNamn.getText();
				String address = textField_adress.getText();
				
				if(!customerNbr.equals("") && !name.equals("") && !address.equals("")){
					if (controller.searchCustomerinList(customerNbr) == null){
						Customer addThisCustomer = new Customer(customerNbr, name, address);
						controller.addCustomerToList(addThisCustomer);
						textArea.setText("Kund har blivit tillagd i registret.");
					}
					else if (controller.searchCustomerinList(customerNbr) != null){
					textArea.setText("Kund finns redan i register.");
					}
				}
				else{
					textArea.setText("Ange giltig information i fälten: kundnummer, namn och adress");
				}
				textField_kundNummer.setText("");
				textField_kundNamn.setText("");
				textField_adress.setText("");
				
			}
		});
		btnSkapaKund.setBounds(251, 27, 131, 25);
		frame.getContentPane().add(btnSkapaKund);
		
		JButton btnSkKund = new JButton("S\u00F6k kund");
		btnSkKund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String customerNbr = textField_kundNummer.getText();
				Customer foundCustomer = controller.searchCustomerinList(customerNbr);
				
				if (!customerNbr.equals("")){
					if ( foundCustomer != null){
						textArea.setText("Namn: " + foundCustomer.getName() + "\n"+ "Adress: " + foundCustomer.getAddress()); 
					}
					else if (foundCustomer == null){
						textArea.setText("Kund finns ej i registret.");
					}
				}
				else{
					textArea.setText("Ange giltig information i fältet: kundnummer.");
				}
				textField_kundNummer.setText("");
				textField_kundNamn.setText("");
				textField_adress.setText("");
			}
		});
		btnSkKund.setBounds(251, 62, 131, 25);
		frame.getContentPane().add(btnSkKund);
		
		JButton btnTaBortKund = new JButton("Ta bort kund");
		btnTaBortKund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String customerNbr = textField_kundNummer.getText();
				
				if (!customerNbr.equals("")){
					Customer removeThisCustomer = controller.removeCustomerFromList(customerNbr);
					if (removeThisCustomer != null){
						textArea.setText("Kund har blivit borttagen ur registret.");
					}
					else if (removeThisCustomer == null){
						textArea.setText("Kund finns ej i registret.");
					}
				}
				else {
					textArea.setText("Ange giltig information i fältet: kundnummer.");
				}
				textField_kundNummer.setText("");
				textField_kundNamn.setText("");
				textField_adress.setText("");
			}
		});
		btnTaBortKund.setBounds(251, 97, 131, 25);
		frame.getContentPane().add(btnTaBortKund);
		
		JButton btnndraKund = new JButton("\u00C4ndra kund");
		btnndraKund.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String customerNbr = textField_kundNummer.getText();
				String customerName = textField_kundNamn.getText();
				String customerAddress = textField_adress.getText();
				
				if (!customerNbr.equals("") && !customerName.equals("") && !customerAddress.equals("")){
					Customer foundCustomer = controller.changeCustomerInList(customerNbr, customerName, customerAddress);
					if (foundCustomer != null){
						textArea.setText("Uppdaterade uppgifter för kund med nummer: " + foundCustomer.getCustomerNbr() + "\n" + "Uppdaterat namn: " + foundCustomer.getName() + "\n"+ "Uppdaterad adress: " + foundCustomer.getAddress());
					}
					else if (foundCustomer == null){
						textArea.setText("Kund finns ej i registret.");
					}
				}
				else {
					textArea.setText("Ange giltig information i fälten: kundnummer, namn och adress.");
				}
				textField_kundNummer.setText("");
				textField_kundNamn.setText("");
				textField_adress.setText("");
			}
		});
		btnndraKund.setBounds(251, 135, 131, 25);
		frame.getContentPane().add(btnndraKund);
		
		JLabel lblProduktnummer = new JLabel("Produktnamn");
		lblProduktnummer.setBounds(399, 31, 91, 16);
		frame.getContentPane().add(lblProduktnummer);
		
		JLabel lblKategori = new JLabel("Kategori");
		lblKategori.setBounds(399, 66, 66, 16);
		frame.getContentPane().add(lblKategori);
		
		JLabel lblPris = new JLabel("Pris");
		lblPris.setBounds(399, 101, 56, 16);
		frame.getContentPane().add(lblPris);
		
		textField_produktNamn = new JTextField();
		textField_produktNamn.setBounds(502, 28, 116, 22);
		frame.getContentPane().add(textField_produktNamn);
		textField_produktNamn.setColumns(10);
		
		textField_kategori = new JTextField();
		textField_kategori.setBounds(502, 62, 116, 22);
		frame.getContentPane().add(textField_kategori);
		textField_kategori.setColumns(10);
		
		textField_pris = new JTextField();
		textField_pris.setBounds(502, 98, 116, 22);
		frame.getContentPane().add(textField_pris);
		textField_pris.setColumns(10);
		
		JButton btnSkapaProdukt = new JButton("Skapa produkt");
		btnSkapaProdukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField_produktNamn.getText();
				String category = textField_kategori.getText();
				Integer price = new Integer(textField_pris.getText());
				
				if (!name.equals("") && !category.equals("") && price != null){
					if (controller.searchProductInList(name) == null){
						Product addThisProduct = new Product (name, category, price);
						controller.addProductToList(addThisProduct);
						textArea.setText("Produkt har blivit tillagd i registret.");
					}	
					else if (controller.searchProductInList(name) != null){
						textArea.setText("Produkt finns redan i registret.");
					}
				}
				else {
					textArea.setText("Ange giltig information i fälten: produktnamn, kategori och pris.");
				}
				textField_produktNamn.setText("");
				textField_kategori.setText("");
				textField_pris.setText("");
			}
		});
		btnSkapaProdukt.setBounds(630, 27, 131, 25);
		frame.getContentPane().add(btnSkapaProdukt);
		
		JButton btnSkProdukt = new JButton("S\u00F6k produkt");
		btnSkProdukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = textField_produktNamn.getText();
				
				if (!name.equals("")){
					Product foundProduct = controller.searchProductInList(name);
					if(foundProduct != null){
						textArea.setText("Kategori: " + foundProduct.getCategory() + "\n" + "Pris: " + foundProduct.getPrice());
					}
					else if (foundProduct == null){
						textArea.setText("Produkt finns ej i registret.");
					}
				}
				else {
					textArea.setText("Ange giltig information i fältet: produktnamn.");
				}
				textField_produktNamn.setText("");
				textField_kategori.setText("");
				textField_pris.setText("");
			}
		});
		btnSkProdukt.setBounds(630, 62, 131, 25);
		frame.getContentPane().add(btnSkProdukt);
		
		JButton btnTaBortProdukt = new JButton("Ta bort produkt");
		btnTaBortProdukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String productName = textField_produktNamn.getText();
				
				if (!productName.equals("")){
					Product removeThisProduct = controller.removeProductFromList(productName);
					if (removeThisProduct != null){
						textArea.setText("Produkt är nu borttagen ur registret.");
					}
					else if (removeThisProduct == null){
						textArea.setText("Produkt finns ej i registret.");
					}
				}
				else{
					textArea.setText("Ange giltig information i fältet: produktnamn.");
				}
				textField_produktNamn.setText("");
				textField_kategori.setText("");
				textField_pris.setText("");
			}	
		});
		btnTaBortProdukt.setBounds(630, 97, 131, 25);
		frame.getContentPane().add(btnTaBortProdukt);
		
		JButton btnndraProdukt = new JButton("\u00C4ndra produkt");
		btnndraProdukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String productName = textField_produktNamn.getText();
				String category = textField_kategori.getText();
				Integer price = new Integer(textField_pris.getText());
				
				if (!productName.equals("") && !category.equals("") && price != null){
					Product foundProduct = controller.changeProductInList(productName, category, price);
					if (foundProduct != null){
						textArea.setText("Produktens information har uppdaterats till: \n" + foundProduct.getProductName() + "\n" + foundProduct.getCategory() + "\n" + foundProduct.getPrice());
					}
					else if (foundProduct == null){
						textArea.setText("Produkt finns ej i registret.");
					}
				}
				else{
					textArea.setText("Ange giltig information i fälten: produktnamn, kategori och pris.");
				}
				textField_produktNamn.setText("");
				textField_kategori.setText("");
				textField_pris.setText("");
			}
		});
		btnndraProdukt.setBounds(630, 135, 131, 25);
		frame.getContentPane().add(btnndraProdukt);
		
		textField_serieNummer = new JTextField();
		textField_serieNummer.setBounds(502, 232, 116, 22);
		frame.getContentPane().add(textField_serieNummer);
		textField_serieNummer.setColumns(10);
		
		JLabel lblKund = new JLabel("KUND");
		lblKund.setBounds(12, 2, 56, 16);
		frame.getContentPane().add(lblKund);
		
		JLabel lblProdukt = new JLabel("PRODUKT");
		lblProdukt.setBounds(399, 2, 56, 16);
		frame.getContentPane().add(lblProdukt);
		
		JLabel lblSerienummer = new JLabel("Serienummer");
		lblSerienummer.setBounds(399, 235, 91, 16);
		frame.getContentPane().add(lblSerienummer);
		
		JLabel lblExemplar = new JLabel("EXEMPLAR");
		lblExemplar.setBounds(399, 206, 80, 16);
		frame.getContentPane().add(lblExemplar);
		
		JButton btnSkapaExemplar = new JButton("Skapa exemplar");
		btnSkapaExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String serialNumber = textField_serieNummer.getText();
				String productName = textField_produktNamn.getText();
				
				if (!serialNumber.equals("") && !productName.equals("")){
					if (controller.searchIteminList(textField_serieNummer.getText()) == null){
						Product foundProduct = controller.searchProductInList(productName);
						if (foundProduct != null){
							controller.addItemToList(new Item (serialNumber, foundProduct));
							textArea.setText("Exemplar har blivit tillagd till produkt.");
						}
						else if (foundProduct == null){
							textArea.setText("Exemplar måste tillhöra en befintlig produkt, vänligen ange giltigt produktnamn i rutan.");
						}
					}
					else{
						textArea.setText("Exemplar finns redan i registret.");
					}
				}
				else{
					textArea.setText("Ange giltig information i fälten: serienummer och produktnamn.");
				}
				textField_serieNummer.setText("");
			}
		});
		btnSkapaExemplar.setBounds(630, 231, 131, 25);
		frame.getContentPane().add(btnSkapaExemplar);
		
		JButton btnTaBortExemplar = new JButton("Ta bort exemplar");
		btnTaBortExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String serialNumber = textField_serieNummer.getText();
				
				if (!serialNumber.equals("")){
					Item removeThisItem = controller.removeItemFromList(serialNumber);
					if (removeThisItem != null){
						textArea.setText("Exemplar är borttaget.");
					}
					else if (removeThisItem == null){
						textArea.setText("Exemplar finns ej i registret.");
					}
				}
				else{
					textArea.setText("Ange giltig information i fältet: serienummer.");
				}
				textField_serieNummer.setText("");
			}
		});
		btnTaBortExemplar.setBounds(630, 267, 131, 25);
		frame.getContentPane().add(btnTaBortExemplar);
		
		JLabel lblOrdernummer = new JLabel("Ordernummer");
		lblOrdernummer.setBounds(12, 235, 89, 16);
		frame.getContentPane().add(lblOrdernummer);
		
		textField_orderNummer = new JTextField();
		textField_orderNummer.setBounds(123, 232, 116, 22);
		frame.getContentPane().add(textField_orderNummer);
		textField_orderNummer.setColumns(10);
		
		JButton btnSkapaOrder = new JButton("Skapa order");
		btnSkapaOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String orderID = textField_orderNummer.getText();
				String deliveryDate = textField_leveransDatum.getText();
				String customerNbr = textField_kundNummer.getText();
				
				if (!orderID.equals("") && !deliveryDate.equals("") && !customerNbr.equals("")){
					if (controller.searchOrderinList(orderID) == null){
						Customer foundCustomer = controller.searchCustomerinList(customerNbr);
						if (foundCustomer != null){
							Order addThisOrder = new Order (orderID, deliveryDate, foundCustomer);
							controller.addOrderToList(addThisOrder);
							textArea.setText("Order har blivit tillagd till kund.");
						}
						else if (foundCustomer == null){
							textArea.setText("Order måste tillhöra befintlig kund, vänligen ange ett giltig kundnummer i rutan.");
						}
					}
					else if (controller.searchOrderinList(orderID) != null){
					textArea.setText("Order finns redan i registret.");
					}
				}
				else {
					textArea.setText("Ange giltig information i fälten: kundnummer, leveransdatum och ordernummer.");
				}
				textField_orderNummer.setText("");
				textField_leveransDatum.setText("");
				textField_kundNummer.setText("");
			}
		});
		btnSkapaOrder.setBounds(251, 231, 131, 25);
		frame.getContentPane().add(btnSkapaOrder);
		
		JButton btnSkOrder = new JButton("S\u00F6k order");
		btnSkOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String orderID = textField_orderNummer.getText();
				
				if (!orderID.equals("")){
					Order foundOrder = controller.searchOrderinList(orderID);
					if (foundOrder != null){
						textArea.setText("Leveransdatum: " + foundOrder.getDeliveryDate() + "\n" + "Tillhörande kund: \n" + "Kundnummer: " + foundOrder.getCustomer().getCustomerNbr() + "\n" + "Namn: " + foundOrder.getCustomer().getName() + "\n" + "Adress: " + foundOrder.getCustomer().getAddress());
					}
					else if (foundOrder == null){
						textArea.setText("Order finns ej i registret.");
					}
				}
				else{
					textArea.setText("Ange giltig information i fältet: ordernummer.");
				}
				textField_orderNummer.setText("");
			}
		});
		btnSkOrder.setBounds(251, 267, 131, 25);
		frame.getContentPane().add(btnSkOrder);
		
		JButton btnTaBortOrder = new JButton("Ta bort order");
		btnTaBortOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String orderID = textField_orderNummer.getText();
				
				if (!orderID.equals("")){
					Order removeThisOrder = controller.removeOrderFromList(orderID);
					if (removeThisOrder != null){
						textArea.setText("Order har blivit borttagen ur registret.");
					}
					else if (removeThisOrder == null){
						textArea.setText("Order finns ej i registret.");
					}
				}
				else {
					textArea.setText("Ange giltig information i fälter: ordernummer.");
				}
				textField_orderNummer.setText("");
			}
		});
		btnTaBortOrder.setBounds(251, 305, 131, 25);
		frame.getContentPane().add(btnTaBortOrder);
		
		textField_leveransDatum = new JTextField();
		textField_leveransDatum.setBounds(123, 270, 116, 22);
		frame.getContentPane().add(textField_leveransDatum);
		textField_leveransDatum.setColumns(10);
		
		JLabel lblLeveransdatum = new JLabel("Leveransdatum");
		lblLeveransdatum.setBounds(12, 273, 89, 16);
		frame.getContentPane().add(lblLeveransdatum);
		
		JLabel lblOrder = new JLabel("ORDER");
		lblOrder.setBounds(12, 206, 56, 16);
		frame.getContentPane().add(lblOrder);
		
		textField_orderRadsNummer = new JTextField();
		textField_orderRadsNummer.setBounds(123, 395, 116, 22);
		frame.getContentPane().add(textField_orderRadsNummer);
		textField_orderRadsNummer.setColumns(10);
		
		JLabel lblOrderradsnummer = new JLabel("Orderradsnummer");
		lblOrderradsnummer.setBounds(12, 398, 107, 16);
		frame.getContentPane().add(lblOrderradsnummer);
		
		JButton btnSkapaOrderrad = new JButton("Skapa orderrad");
		btnSkapaOrderrad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idNumber = textField_orderRadsNummer.getText();
				Integer orderLineQuantity = new Integer (textField_kvantitet.getText());
				String orderID = textField_orderNummer.getText();
				String productName = textField_produktNamn.getText();
				
				if (!idNumber.equals("") && !orderLineQuantity.equals("") && !orderID.equals("") && !productName.equals("")){
					if (controller.searchOrderLineinList(idNumber) == null){
						Order foundOrder = controller.searchOrderinList(orderID);
						if (foundOrder != null){
							Product foundProduct = controller.searchProductInList(productName);
							if (foundProduct != null && orderLineQuantity < controller.getItemQuantity(foundProduct)){
								OrderLine addThisOrderLine = new OrderLine (idNumber, orderLineQuantity, foundOrder, foundProduct);
								controller.addOrderLineToList(addThisOrderLine);
								textArea.setText("Orderrad har blivit tillagd till order.");
							}
							else if(orderLineQuantity > controller.getItemQuantity(foundProduct)){
								textArea.setText("Ej tillräckligt med varor i lager.");
							}
							else if (foundProduct == null){
								textArea.setText("Orderrad måste innehålla en produkt, vänligen ange giltigt produktnamn i rutan.");
							}
						}
						else if (foundOrder == null){
							textArea.setText("Orderrad måste tillhöra en order, vänligen ange gilitigt ordernummer i rutan.");;
						}
					}
					else if (controller.searchOrderLineinList(idNumber) != null){
						textArea.setText("Orderrad finns redan i registret, ange giltigt orderradsnummer.");
					}
				}
				else {
					textArea.setText("Ange giltig information i fälten: orderradsnummer, kvantitet, produktnamn och ordernummer.");
				}
				textField_orderRadsNummer.setText("");
				textField_kvantitet.setText("");
				textField_orderNummer.setText("");
				textField_produktNamn.setText("");
			}
		});
		btnSkapaOrderrad.setBounds(251, 394, 131, 25);
		frame.getContentPane().add(btnSkapaOrderrad);
		
		btnTaBortOrderrad = new JButton("Ta bort orderrad");
		btnTaBortOrderrad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String idNumber = textField_orderRadsNummer.getText();
				
				if (!idNumber.equals("")){
					controller.removeOrderLineFromList(idNumber);
					textArea.setText("Orderraden har blivit borttagen.");
				}
				else{
					textArea.setText("Ange giltig information i fälten.");
				}
				textField_orderRadsNummer.setText("");
			}
		});
		btnTaBortOrderrad.setBounds(251, 432, 131, 25);
		frame.getContentPane().add(btnTaBortOrderrad);
		
		lblOrderrad = new JLabel("ORDERRAD");
		lblOrderrad.setBounds(12, 369, 89, 16);
		frame.getContentPane().add(lblOrderrad);
		
		btnSkExemplar = new JButton("S\u00F6k exemplar");
		btnSkExemplar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String serialNumber = textField_serieNummer.getText();
				
				if (!serialNumber.equals("")){	
					Item foundItem = controller.searchIteminList(serialNumber);
					if (foundItem != null){
						textArea.setText("Tillhörande produkt: \n" + "Namn: " + foundItem.getProduct().getProductName() + "\n" + "Kategori: " + foundItem.getProduct().getCategory() + "\n" + "Pris: " + foundItem.getProduct().getPrice());
					}
					else if (foundItem == null){
						textArea.setText("Exemplar finns ej i registret.");
					}
				}
				else{
					textArea.setText("Ange giltig information i fältet: serienummer.");
				}
				textField_serieNummer.setText("");
			}
		});
		btnSkExemplar.setBounds(502, 266, 116, 25);
		frame.getContentPane().add(btnSkExemplar);
		
		textArea = new JTextArea(); 
		textArea.setLineWrap(true);
		textArea.setBounds(441, 305, 320, 157);
		frame.getContentPane().add(textArea);
		
		textField_kvantitet = new JTextField();
		textField_kvantitet.setBounds(123, 433, 116, 22);
		frame.getContentPane().add(textField_kvantitet);
		textField_kvantitet.setColumns(10);
		
		JLabel lblKvantitet = new JLabel("Kvantitet");
		lblKvantitet.setBounds(12, 427, 56, 16);
		frame.getContentPane().add(lblKvantitet);
		
		JButton btnVisaTotalbelopp = new JButton("Visa totalbelopp");
		btnVisaTotalbelopp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String orderNumber = textField_orderNummer.getText();
				
				if (!orderNumber.equals("")){
					int totalAmount = controller.totalAmountForOrder(orderNumber);
					textArea.setText("Totala priset för order är: \n" + totalAmount);
				}
				else {
					textArea.setText("Ange giltig information i fältet: ordernummer.");
				}
			}
		});
		btnVisaTotalbelopp.setBounds(251, 197, 131, 25);
		frame.getContentPane().add(btnVisaTotalbelopp);
	}
}
