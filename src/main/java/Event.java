public class Event extends Task{
    protected String at;

    Event(String title, String when){
        super(title);
        this.type = "[E]";
        this.at = when;
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + at + ")";
    }

}