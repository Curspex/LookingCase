package sx.cur.omnivion.lookingcase.lang;

public enum Meta {


	VIEWING("Viewing"),
	SELECTION("Selection");


	private final String string;

	Meta(String string) { this.string = string; }

	@Override
	public String toString()
	{
		return this.string;
	}


}