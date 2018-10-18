/* do NOT succumb to single line conditionals */
/* do NOT succumb to single line functions */


/* shit */
public class CommentWidget extends TextWidget
{
    public static final String REGEXP = "^#^[^\r\n]*(?:(?:\r\n(|\n|\r)?";
    public CommentWidget(ParentWidget parent, String text){super(parent, text);}
    public String render() throws Exception {return ""; }
}


/* not shit */
public class CommentWidget extends TextWidget
{
    public static final String REGEXP = "^#^[^\r\n]*(?:(?:\r\n(|\n|\r)?";

    public CommentWidget(ParentWidget parent, String text) {
        super(parent, text);
    }

    public String render() throws Exception {
        return ""; 
    }
}
