package chap7;
//Bean Ŭ����
public class Book {
	private String writer;
	private String title;
	private String content;
	public String getWr() { //����� �̸��� property���ƴϰ� get�� �̸��� property
		return writer;
	}
	public void setWr(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
