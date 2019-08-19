public class Todo {
    public String title = null;
    public String description = null;
    public boolean done = false;

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

    public void setDone(boolean d){
        done = d;
    }

}