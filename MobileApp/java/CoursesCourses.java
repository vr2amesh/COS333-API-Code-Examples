import java.util.HashMap;

/*
This endpoint takes up to three parameters:

term, subject, search

Term is a required parameter. The other two
parameters work a slightly different way. 
You should only provide one of these two
parameters in order to make a valid query
to this endpoint.

If you provide only the subject parameter,
the endpoint will return all courses 
within that subject for the term. That is, 
if for example you pass in 'COS', all classes
within the COS department will be returned.
Keep in mind that this must be all capital 
letters.

If you provide only the search parameter,
the endpoint will query all courses in the Registrar
and return all courses which match the search query.
For example, a search value of 'intro' would return 
all courses with the string 'intro' in either the
Course Title, Course Description, Professor Name,
or the Course Department Code.

If both the subject and search are provided, then 
the endpoint will return an OR of the two. That is,
a course will be returned if EITHER it matches the 
subject parameter OR the search parameter.
*/

public class CoursesCourses {
    public static void main(String[] args) {
        ReqLib reqLib = new ReqLib();
        String endpoint = reqLib.configs.course_courses;
        HashMap<String, Object> params = new HashMap<String, Object>();
        String spring_2020_term_code = "1204";
        String subj = "COS";

        params.put("fmt", "json");
        params.put("term", spring_2020_term_code);
        params.put("subject", subj);

        try {
            String courses = reqLib.getRequest(endpoint, params);
            System.out.println(courses);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}