public class Todo {
    protected String title = null;
    protected String description = null;
    protected boolean done = false;

    Todo(String todoTitle) {
        title = todoTitle;
      }

    public String getTitle(){
        return title;
    }

    public void setTitle(String todoTitle){
        title = todoTitle;
    }

    public boolean getDone(){
        return done;
    }

    public String getStatusIcon() {
        return (done ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void setDone(boolean d){
        done = d;
    }

}