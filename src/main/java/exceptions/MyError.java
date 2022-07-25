package exceptions;

public class MyError {

	private String messageUser;
	private String messageDev;

	public MyError(String messageUser, String messageDev) {
		this.messageUser = messageUser;
		this.messageDev = messageDev;
	}

	public String getMessageUser() {
		return messageUser;
	}

	public String getMessageDev() {
		return messageDev;
	}

}
