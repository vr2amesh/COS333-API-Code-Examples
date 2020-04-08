#!/usr/bin/env python3
from req_lib import ReqLib

'''
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
'''
if __name__ == "__main__":
    req_lib = ReqLib()
    spring_2020_term_code = "1204"
    subj = "COS"

    # Returns all courses in COS
    term_info = req_lib.getJSON(
        req_lib.configs.COURSE_COURSES,
        # To return a json version of the return value
        fmt="json",
        term=spring_2020_term_code, 
        subject=subj,
    )
    print(term_info)

    for term in term_info["term"]:
        for subject in term["subjects"]:
            for course in subject["courses"]:

                # prints each individual course returned
                # by the endpoint. Each course has the 
                # following parameters:

                # guid (string of the term code and course id concatenated. Unique each term)
                # course_id (course id according to the course registrar. Not unique each term)
                # catalog_number (catalog number of the course. So, for COS 126 this would be 126)
                # title (Title of the course)
                # detail (detailed information about the course [start/end date, track, description])
                # instructors 
                # crosslistings (any crosslistings, if they exist)
                # classes (class meetings, each section that is within the class)
                print(course)
