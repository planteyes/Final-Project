package p1;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.text.DecimalFormat;
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import p1.stackClark.Node;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Slider;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class test {

	;
	private static Text add_inv_NAME_TEXT;
	private static Text add_inv_PRICE_TEXT;
	private static Text remove_inv_text;
	private static Text add_checkpoint_text;
	private static Text text_7;
	private static Text text;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Queue checkout = new Queue(10);
		stackClark<String> stack = new stackClark<String>();

		Display display = Display.getDefault();
		Shell EasyRegister = new Shell();
		EasyRegister.setSize(1262, 586);
		EasyRegister.setText("Easy Register\r\n");

		Label label_1 = new Label(EasyRegister, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(655, 212, 579, 20);

		Label lblNewLabel = new Label(EasyRegister, SWT.NONE);
		lblNewLabel.setBounds(682, 181, 103, 20);
		lblNewLabel.setText("Running Total");

		Label lblNewLabel_1 = new Label(EasyRegister, SWT.NONE);
		lblNewLabel_1.setBounds(810, 181, 94, 20);
		lblNewLabel_1.setText("0");

		Label lblReimbursmentOffered = new Label(EasyRegister, SWT.NONE);
		lblReimbursmentOffered.setBounds(655, 320, 166, 20);
		lblReimbursmentOffered.setText("Reimbursment offered :");

		Label lblAddToInventory = new Label(EasyRegister, SWT.NONE);
		lblAddToInventory.setBounds(10, 56, 113, 20);
		lblAddToInventory.setText("Add To Inventory");

		add_inv_NAME_TEXT = new Text(EasyRegister, SWT.BORDER);
		add_inv_NAME_TEXT.setBounds(129, 53, 78, 26);
		add_inv_PRICE_TEXT = new Text(EasyRegister, SWT.BORDER);
		add_inv_PRICE_TEXT.setBounds(213, 53, 78, 26);

		Label lblName = new Label(EasyRegister, SWT.NONE);
		lblName.setBounds(129, 85, 70, 20);
		lblName.setText("Name");

		Label lblPrice = new Label(EasyRegister, SWT.NONE);
		lblPrice.setBounds(213, 85, 70, 20);
		lblPrice.setText("Price");

		Label lblRemoveFrom = new Label(EasyRegister, SWT.NONE);
		lblRemoveFrom.setBounds(10, 117, 94, 20);
		lblRemoveFrom.setText("Remove from");

		Label lblId_1 = new Label(EasyRegister, SWT.NONE);
		lblId_1.setBounds(221, 143, 70, 20);
		lblId_1.setText("ID");

		Label lblInventory = new Label(EasyRegister, SWT.NONE);
		lblInventory.setBounds(106, 117, 70, 20);
		lblInventory.setText("Inventory");

		Text Find_ID_Results = new Text(EasyRegister, SWT.BORDER | SWT.WRAP | SWT.READ_ONLY | SWT.V_SCROLL);
		Find_ID_Results.setBounds(10, 246, 492, 156);
		Find_ID_Results.setText("Results");

		remove_inv_text = new Text(EasyRegister, SWT.BORDER);
		remove_inv_text.setBounds(213, 111, 78, 26);

		Button btnAdd = new Button(EasyRegister, SWT.NONE);
		btnAdd.setBounds(297, 51, 90, 30);
		btnAdd.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					String addNAMETEXT = add_inv_NAME_TEXT.getText();
					String addPRICETEXT = add_inv_PRICE_TEXT.getText();
					System.out.println(addNAMETEXT);
					System.out.println(addPRICETEXT);
					double result1 = Double.parseDouble(addPRICETEXT);
					stack.push(addNAMETEXT, result1);
					add_inv_NAME_TEXT.setText("");
					add_inv_PRICE_TEXT.setText("");
					break;
				}
			}
		});
		btnAdd.setText("Add");

		Button btnRemove = new Button(EasyRegister, SWT.NONE);
		btnRemove.setBounds(297, 109, 90, 30);
		btnRemove.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					String rit = remove_inv_text.getText();
					int result1 = Integer.parseInt(rit);
					stack.remove(result1);
					System.out.println(rit + " has been removed");
					remove_inv_text.setText("");
					System.out.println(stack.peek());
					rit = null;
					break;

				}
			}
		});
		btnRemove.setText("Remove");

		Button SortBy_ID = new Button(EasyRegister, SWT.NONE);
		SortBy_ID.setBounds(10, 408, 90, 30);
		SortBy_ID.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					System.out.println("Button pressed");
					for (int i = 0; i < 1000; i++) {
						stack.sort();
					}
					Find_ID_Results.setText(stack.toString());
					System.out.println("done sorting");
					break;
				}
			}
		});
		SortBy_ID.setText("Sort");

		Label lblViewInventory = new Label(EasyRegister, SWT.NONE);
		lblViewInventory.setBounds(374, 498, 103, 20);
		lblViewInventory.setText("View Inventory");

		Button btnNewButton_1 = new Button(EasyRegister, SWT.NONE);
		btnNewButton_1.setBounds(492, 487, 90, 30);
		btnNewButton_1.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					System.out.println("Button pressed");

					Find_ID_Results.setText(stack.toString());
					break;
				}
			}
		});

		btnNewButton_1.setText("View");

		Label lblCheckout = new Label(EasyRegister, SWT.NONE);
		lblCheckout.setBounds(865, 0, 70, 20);
		lblCheckout.setText("Checkout");

		Label lblInventory_1 = new Label(EasyRegister, SWT.NONE);
		lblInventory_1.setBounds(203, 0, 70, 20);
		lblInventory_1.setText("Inventory");

		Label lblAddToCheckout = new Label(EasyRegister, SWT.NONE);
		lblAddToCheckout.setBounds(674, 82, 146, 20);
		lblAddToCheckout.setText("Add to Checkout List");

		add_checkpoint_text = new Text(EasyRegister, SWT.BORDER);
		add_checkpoint_text.setBounds(826, 82, 78, 26);

		Label lblId_4 = new Label(EasyRegister, SWT.NONE);
		lblId_4.setBounds(860, 56, 70, 20);
		lblId_4.setText("ID");

		Label lblViewCheckoutList = new Label(EasyRegister, SWT.NONE);
		lblViewCheckoutList.setBounds(674, 134, 123, 20);
		lblViewCheckoutList.setText("View Checkout list");

		Button btnNewButton_2 = new Button(EasyRegister, SWT.NONE);
		btnNewButton_2.setBounds(818, 129, 90, 30);
		btnNewButton_2.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:

					Find_ID_Results.setText(checkout.print());
					System.out.println("Button pressed");
					break;
				}
			}
		});
		btnNewButton_2.setText("View");

		Button btnNewButton_4 = new Button(EasyRegister, SWT.NONE);
		btnNewButton_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_4.setBounds(928, 82, 90, 30);
		btnNewButton_4.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:

					String checkouttext = add_checkpoint_text.getText();
					int ck = Integer.parseInt(checkouttext);
					Node a = stack.addcheckout(ck);
					checkout.enqueue((String) a.item, a.price, a.id);
					System.out.println("Button pressed");
					Find_ID_Results.setText(checkout.print());

					String running = lblNewLabel_1.getText();
					double running2 = Double.parseDouble(running);
					double running3 = stack.findD(ck);
					double last = (running2 + running3);
					lblNewLabel_1.setText(String.valueOf(last));
					break;
				}
			}
		});

		btnNewButton_4.setText("Add");
		Label label_2 = new Label(EasyRegister, SWT.NONE);
		label_2.setBounds(872, 460, 70, 20);
		label_2.setText("$:");
		text_7 = new Text(EasyRegister, SWT.BORDER);
		text_7.setBounds(872, 317, 78, 26);

		Button btnCalculateChange = new Button(EasyRegister, SWT.NONE);
		btnCalculateChange.setBounds(1021, 315, 160, 30);
		btnCalculateChange.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					DecimalFormat df = new DecimalFormat("#.##");
					String change = text_7.getText();
					double change2 = Double.parseDouble(change);
					String running = lblNewLabel_1.getText();
					double running2 = Double.parseDouble(running);
					Double total = change2 - running2;
					label_2.setText(String.valueOf(df.format(total)));
					System.out.println("Button pressed");
					break;
				}
			}
		});

		btnCalculateChange.setText("Calculate Change");

		Label lblChangeForCustomer = new Label(EasyRegister, SWT.NONE);
		lblChangeForCustomer.setBounds(826, 408, 146, 20);
		lblChangeForCustomer.setText("Change for Customer");

		Label lblcannotRemoveLast = new Label(EasyRegister, SWT.NONE);
		lblcannotRemoveLast.setBounds(393, 114, 216, 20);
		lblcannotRemoveLast.setText("{cannot remove last element}");

		Label lblSortInventoryBy = new Label(EasyRegister, SWT.NONE);
		lblSortInventoryBy.setBounds(106, 408, 129, 20);
		lblSortInventoryBy.setText("Sort Inventory");

		Label lblFindItem = new Label(EasyRegister, SWT.NONE);
		lblFindItem.setBounds(10, 183, 70, 20);
		lblFindItem.setText("Find Item ");

		text = new Text(EasyRegister, SWT.BORDER);
		text.setBounds(97, 180, 78, 26);

		Label lblId = new Label(EasyRegister, SWT.NONE);
		lblId.setBounds(97, 212, 70, 20);
		lblId.setText("ID");

		Label results = new Label(EasyRegister, SWT.NONE);
		results.setBounds(290, 183, 306, 27);
		results.setText(":");

		Button btnFind = new Button(EasyRegister, SWT.NONE);
		btnFind.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFind.setBounds(183, 180, 90, 30);
		btnFind.setText("Find");
		btnFind.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					String rit3 = text.getText();
					int result3 = Integer.parseInt(rit3);
					results.setText(":" + stack.Find(result3).toString());
					System.out.println("Button pressed");
					break;
				}
			}
		});

		text.setText(stack.toString());

		Label label = new Label(EasyRegister, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(607, 10, 21, 519);

		EasyRegister.open();
		EasyRegister.layout();
		while (!EasyRegister.isDisposed())

		{
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
}
