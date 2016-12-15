# Android-ClassesHelpers
##Browser: 
	Browser.navigateURL(MainActivity.this, "www.linkedin.com/in/ericserafim");	
##Maps: 
	//Open address
    Maps.open(MainActivity.this, "English Bay Beach");

	//Open lat and long, with zoom and caption
	Maps.open(MainActivity.this, 49.2851114f,-123.1426406f, 100, "English Bay Beach");
	
##Video:
	Video.open(MainActivity.this, "https://youtu.be/v-08_7IbGdQ");
	
##Mailto:
	MailTo.send(MainActivity.this,
                        "ericserafim@gmail.com",
                        "Email via app example",
                        "Body message");

##DialogCustom:
	DialogCustom.information(MainActivity.this,
                        "Information",
                        "Message",
                        "Ok",
                        true,//modal
                        null
                );

	DialogCustom.confirmation(MainActivity.this,
			"Confirmation",
			"Message",
			"Yes",
			"No",
			true,//modal
			new DialogCustomInterface.OnClickListenerPositive() {
				@Override
				public void onClick() {
					//say "yes"
				}
			},
			new DialogCustomInterface.OnClickListenerNegative() {
				@Override
				public void onClick() {
					//say "no"
				}
			}
	);

	EditText editText = new EditText(MainActivity.this);
	editText.setHint("something...");

	DialogCustom.confirmation(MainActivity.this,
			editText,
			"Confirmation with view",
			"Message",
			"Yes",
			"No",
			true,//modal
			new DialogCustomInterface.OnClickListenerPositive() {
				@Override
				public void onClick() {
					//say "yes"
				}
			},
			new DialogCustomInterface.OnClickListenerNegative() {
				@Override
				public void onClick() {
					//say "no"
				}
			}
	);
	
##SnackCustom:
	SnackbarCustom.show(fab, "Message for you!!!");
	
##Phone:
	Phone.getIMEI(MainActivity.this)
	Phone.dial(MainActivity.this, "123456789");
