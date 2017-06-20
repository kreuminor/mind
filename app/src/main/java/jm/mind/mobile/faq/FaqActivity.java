package jm.mind.mobile.faq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jm.mind.mobile.MainActivity;
import jm.mind.mobile.R;

public class FaqActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private jm.mind.mobile.faq.ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    ImageButton img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        img = (ImageButton)findViewById(R.id.backbtn);

        listView = (ExpandableListView) findViewById(R.id.lvExp);
        initData();
        listAdapter = new jm.mind.mobile.faq.ExpandableListAdapter(getApplicationContext(), listDataHeader, listHash);
        listView.setAdapter(listAdapter);

        // Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        getSupportActionBar().setTitle("Frequently Asked Questions");

    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Is MIND a recognized training institution?");
        listDataHeader.add("What does accreditation mean?");
        listDataHeader.add("How do I benefit from pursuing an accredited course/programme?");
        listDataHeader.add("Which programmes/courses are accredited?");
        listDataHeader.add("What is the duration of the accreditation status of courses/programmes?");
        listDataHeader.add("How often are courses/programmes reviewed?");
        listDataHeader.add("What is Competency-Based Education and Training?");
        listDataHeader.add("How will I know my examination dates and times?");
        listDataHeader.add("How will I know what room my examination will be held in?");
        listDataHeader.add("Who should I contact if I am unable to make it to an examination if I fall ill?");
 /*       listDataHeader.add("If my examination is cancelled, how will I know?");
        listDataHeader.add("Where do I collect my examination card?");
        listDataHeader.add("Would I be allowed to sit an examination if I forget to take my examination card along with me?");
        listDataHeader.add("What items are allowed inside the examination room?");
        listDataHeader.add("Where do I put my bags, cellular phones books and other non-permitted material for safekeeping while sitting an examination?");
        listDataHeader.add("If I am running late, will I be allowed to sit my examination?");
        listDataHeader.add("I usually finish my examinations before the specified time has elapsed. May I leave the examination room once I am finished writing my paper?");
        listDataHeader.add("If I know that my performance on an examination paper was negatively impacted by illness, how should I communicate this?");
        listDataHeader.add("How long after completing my examination, can I expect to get my results?");
        listDataHeader.add("If I fail my final examination how will I know when I may re-sit it?");
        listDataHeader.add("If I am dissatisfied with my examination results, to whom do I communicate this?");
        listDataHeader.add("How do I apply for credit exemptions?");
        listDataHeader.add("If I have been offered a place in a programme of study but unable to take up the offer for the upcoming period, can I request a deferral?");
        listDataHeader.add("If I am currently enrolled in a programme/course and need to temporarily withdraw, what is the process?");
        listDataHeader.add("What is MIND’s policy if I am unable to complete my programme of study within the stated programme duration?");
        listDataHeader.add("What is the procedure if I am unable to meet the deadline for submission of coursework assignments?");
        listDataHeader.add("Will I be required to meet a minimum attendance at classes?");
        listDataHeader.add("If I do not meet the entry requirements for a programme/course, can I still be considered?");
        listDataHeader.add("When I complete a programme at MIND, can I use the credits gained to matriculate into other tertiary institutions?");
        listDataHeader.add("What arrangements are in place to accommodate participants with special needs?");
*/

        List<String> question1 = new ArrayList<>();
        question1.add("MIND is the Government of Jamaica’s (GOJ’s) pre-eminent and preferred public service training, organizational and leadership development institute in Jamaica, serving the Caribbean. MIND’s role is crucial to the transformation and modernization of the public service in Jamaica and the wider Caribbean region.  MIND is registered with the University Council of Jamaica.");

        List<String> question2 = new ArrayList<>();
        question2.add("Accreditation is the status granted to an institution or programme that has been found, through self-study and peer review, to meet or exceed stated guidelines of educational quality.");

        List<String> question3 = new ArrayList<>();
        question3.add("Accreditation provides students with an assurance that the educational programme(s) of an institution have been found to be satisfactory and should therefore meet the needs of the student.\n" +
                "\n" +
                "An award from an institution with an accredited programme provides students with: (a) prerequisites for entering a profession; (b) a basis for admission into further studies by both local and foreign educational institutions and (c) assistance in the transfer of credits between institutions through the general acceptance of credits among accredited institutions and where the credits to be transferred are appropriate to the receiving institution.");

        List<String> question4 = new ArrayList<>();
        question4.add("The Programmes accredited by  the University Council of Jamaica (UCJ) are the:\n" +
                "\n" + "• Post Graduate Diploma Public Sector Senior Management Development\n" +
                "\n" + "• Post Graduate Diploma Human Resource Management\n" +
                "\n" + "• Post Graduate Diploma General Management\n" +
                "\n" + "• Post Graduate Diploma Tax Audit and Revenue Administration\n" +
                "\n" + "• Associate of Science Degree Accounting\n" +
                "\n" + "• Associate of Science Degree Human Resource Management\n" +
                "\n" + "The Programme accredited by  the National Council on Technical and Vocational Education and Training (NCTVET) is the:\n" +
                "\n" + "• Administrative Management (Levels 1 & 2)");

        List<String> question5 = new ArrayList<>();
        question5.add("Each accrediting body has different accreditation periods. \n" +
                      "Accreditation status of programmes received from NCTVET, spans 4 years.\n" +
                       "Accreditation status of programmes received from UCJ, spans 3 – 5 years.");

        List<String> question6 = new ArrayList<>();
        question6.add("Programmes/courses are reviewed every two (2) to three (3) years in response to new initiatives, policies/legislations, and changes within industries that will have an impact on the content and delivery mode. This ensures that our courses remain relevant. ");

        List<String> question7 = new ArrayList<>();
        question7.add("Competency-Based Education and Training (CBET) provides for participants progressing from one module/course to the next by demonstrating mastery of knowledge and skills (called competencies) required for a particular module/course, regardless of how long it takes.\n" +
                "\n" + "The Agency has infused aspects of Competency-Based Education and Training (CBET) methodologies into its programme/course curriculum. This emphasis relates to creating opportunities for participants to demonstrate competence during their participation on a module/course through in-class activities and or coursework assignments.  As a result, coursework will account for no less than 50% of the final mark and examinations will account for no more than 50% of the final mark. Coursework can be marked out of 100%, taking into account the nature of the module or course.");

        List<String> question8 = new ArrayList<>();
        question8.add("At the beginning of each course, module or semester, participants will be provided with a course timetable by the Course Coordinator. The timetable will include the Schedule of Assessments. The Schedule of Assessments will highlight, where applicable, the examination dates and times.");

        List<String> question9 = new ArrayList<>();
        question9.add("Examination venues are posted on the Participants’ Notice Boards located on the ground and first floors of the building each morning. A notice is also placed at each examination room.  Information may also be obtained from the receptionist at the front desk.");

        List<String> question10 = new ArrayList<>();
        question10.add("In the event of imminent absence from an examination due to medical emergencies, participants should inform a representative of the Registry and Records Management Unit.");
/*
        List<String> question11 = new ArrayList<>();
        question11.add("Examinations may be re-scheduled due to natural disasters, other acts of God, social unrest, and other issues that could prevent a programme/course from being completed on time. The Registry and Records Management Unit will advise all participants who will be affected by the change.");

        List<String> question12 = new ArrayList<>();
        question12.add("Examination cards should be collected from the Accounts Unit. Please note, that only participants who are financially clear will be able to collect examination cards.");

        List<String> question13 = new ArrayList<>();
        question13.add("A participant will not be permitted to sit an examination if he/she does not have his/her examination card and a valid form of identification such as driver’s license, passport and national/work identification card.");

        List<String> question14 = new ArrayList<>();
        question14.add("Examination cards, identification cards, writing implements including pens, pencils, and rulers, non-programmable calculators, geometrical, and other relevant instruments are allowed.\n" +
                "\n" + "Participants must NOT take Programmable /database calculators, text books, documents or pictures of any kind, bags, pencil cases, paper or lecture notes, cellular phones and other smart gadgets inside the examination room.");

        List<String> question15 = new ArrayList<>();
        question15.add("Participants must make arrangements to secure their personal items which are not allowed into the examination room. The Agency may provide a space to keep these items once there is available space to do so. In the event a provision is made, it will be specified on the Participants’ Notice Boards. The Agency accepts no responsibility for items lost, damaged or stolen in these designated spaces.");

        List<String> question16 = new ArrayList<>();
        question16.add("A participant who is late for an examination will be permitted to sit the examination on the condition that no participant has completed the examination and has left the examination room.\n" +
                "\n" + "Once it has been verified that no participant has completed the examination and has left the room, then the late participant will be allowed to sit his/her examination, however, NO extra time will be given for the completion of the paper.\n" +
                "\n" + "This measure is to protect the integrity of the examination.");

        List<String> question17 = new ArrayList<>();
        question17.add("A participant who completes an examination before the time allotted, should communicate his/her desire to leave to the invigilator.  The invigilator may grant permission, provided that the participant does not wish to leave during the first forty-five (45) minutes or last fifteen (15) minutes of the examination.");

        List<String> question18 = new ArrayList<>();
        question18.add("If a participant falls ill while sitting an examination, he/she should inform the invigilator of the situation and a report will be prepared. If the participant’s performance in the examination was affected by the illness or any other serious factors (family related concern/emergency), the candidate should report the circumstances in writing supported by appropriate evidence, to the Senior Manager, Registry and Records Management Unit no later than three (3) days after that examination. The relevant training unit manager will respond to the participant within seven (7) working days.");

        List<String> question19 = new ArrayList<>();
        question19.add("The Registry and Records Management Unit will post the provisional/final assessment results on the Students’ Notice Board no later than six (6) weeks after the sitting of the examination. Results for participants who are not financially clear will not be released / posted until financial clearance is obtained from the Accounts Unit.");

        List<String> question20 = new ArrayList<>();
        question20.add("Participants who qualify to re-sit an examination may do so at the next offering of the examination or at an appropriate date established by the Agency. The Registry and Records Management Unit will advise participants who have filled out the requisite form and paid the re-sit fee, no less than two (2) weeks before the re-sit examination (via telephone call and letter). ");

        List<String> question21 = new ArrayList<>();
        question21.add("Where participants are dissatisfied with the grade awarded for coursework or examination, they should, within ten (10) working days of publication of results, communicate in writing to Senior Manager, Registry and Records Management Unit.\n" +
                "\n" + "A review of the participant’s assessment will be conducted by the facilitator.  Subsequently, the relevant training unit manager will meet and discuss with the participant the decision, where a resolution may be found at this stage. \n" +
                "\n" + "If the participant is still dissatisfied, he/she should submit in writing a re-mark request to the Senior Manager, Registry and Records Management Unit who will reiterate the Appeal/Remark procedures to ensure that the initial steps were executed and then follow through on the remark request.");

        List<String> question22 = new ArrayList<>();
        question22.add("Participants may obtain credit exemption application forms from the Registry and Records Management Unit. For applications for exemption from courses pursued at other registered tertiary level institutions, the following procedures will apply:\n" +
                "\n" + "a. All requests for credit exemptions must be made at least four (4) weeks before a programme commences\n" +
                "\n" + "b. Participants requesting credit exemption(s), must do so in writing on the prescribed form, detailing the:\n" +
                "\n" +
                "\n" + "• Programme in which he/she is currently registered\n" +
                "\n" + "• Name(s) of course(s) from which exemption is being sought\n" +
                "\n" + "• Equivalent courses completed\n" +
                "\n" + "• Grade(s) achieved\n" +
                "\n" + "• Date(s) of completion (must not be more than five (5) years at the time of application)\n" +
                "\n" +
                "\n" + "c. A certified copy of the participant’s academic transcript and detailed information on the programme/course (objectives, lecture and tutorial hours, and assessment details) which is being used to support the application for credit exemption, should be sent by the institution under sealed envelope to the Senior Manager, Registry and Records Management Unit\n" +
                "\n" + "• Programme in which he/she is currently registered\n" +
                "\n" + "• Name(s) of course(s) from which exemption is being sought\n" +
                "\n" + "• Equivalent courses completed\n" +
                "\n" + "• Grade(s) achieved\n" +
                "\n" + "• Date(s) of completion (must not be more than five (5) years at the time of application)\n" +
                "\n" +
                "\n" + "A certified copy of the participant’s academic transcript and detailed information on the programme/course (objectives, lecture and tutorial hours, and assessment details) which is being used to support the application for credit exemption, should be sent by the institution under sealed envelope to the Senior Manager, Registry and Records Management Unit\n" +
                "\n" + "Participants must have obtained a GPA of 3.0 or a grade B for the course being submitted for exemption\n" +
                "\n" + "The course must be accredited and considered relevant to the programme that is currently being pursued\n" +
                "\n" + "Completed application and requisite documentation should be returned to the Senior Manager Registry and Records Management Unit for processing.");

        List<String> question23 = new ArrayList<>();
        question23.add("Yes, you may request a deferral.  \n" +
                "Please note however that deferral of studies is only allowed for programmes, which last for one (1) academic year or longer. Requests for deferrals must be made in writing to the Senior Manager, Registry and Records Management Unit, stating the reason(s) for the request. \n" +
                "An applicant who defers an offer: \n" +
                "i. Must inform MIND in writing within four (4) weeks of receiving the offer. Otherwise, he or she will be required to reapply to the programme for consideration of entry. \n" +
                "ii. Is required to start the programme for which he/she was accepted at the next uptake.");

        List<String> question24 = new ArrayList<>();
        question24.add("You may apply for a Leave of Absence\n" +
                "A Leave of Absence may be given to an active participant for temporary withdrawal from a programme of study, such leave of absence not to exceeding one (1) academic year. The request for a leave of absence must be made in writing to the Senior Manager, Registry and Records Management Unit, stating the reason(s) for the request.");

        List<String> question25 = new ArrayList<>();
        question25.add("Programmes/courses that last for less than one (1) year must be completed within one (1) year from the start date. Programmes/courses of a duration of 1 year and over will be allowed 2 times the course duration for completion.  For example: Associates Degree – 30 months duration so maximum completion time allowed is 60 months.");

        List<String> question26 = new ArrayList<>();
        question26.add("Participants who anticipate being unable to complete a coursework by the due date, must obtain permission in writing from the Manager Scheduled Programme Delivery and Administration, to submit the work by a specified later date. Permission must be requested in writing at least seven (7) working days before the due date. Requests for new dates will only be accommodated where participants demonstrate that it was not reasonably practical to meet the original deadline.");

        List<String> question27 = new ArrayList<>();
        question27.add("Yes\n" +
                "To successfully complete a programme/course, participants must satisfy an 80% minimum attendance requirement. Please note however that participants are required to attend the first week of classes.  There are some courses where the participation required is 100%");

        List<String> question28 = new ArrayList<>();
        question28.add("Yes, you may be considered.\n" +
                "Our accredited programmes/courses have some minimum entry requirements to which we must adhere to maintain their accredited status. Applicants, who do not meet the normal matriculation requirements, may be considered for admission based on mature entry standards, such as years of relevant experience, and assessment of alternative qualifications.");

        List<String> question29 = new ArrayList<>();
        question29.add("Acceptance to another institution using MIND programme/course credits must generally be cleared with the receiving institution.  Our experience has been that participants who have applied to other tertiary institutions have been successful in getting exemptions based on the programme/course of study pursued at MIND. MIND is registered with the University Council of Jamaica (UCJ) and our Associates of Science Degrees as well as our Post Graduate Diplomas are accredited by UCJ.");

        List<String> question30 = new ArrayList<>();
        question30.add("MIND provides equal opportunity for all participants to access training and physical facilities. In an effort to enhance the quality of our services to participants with special needs, the Agency provides support services such as special parking facilities, seating arrangements in training and examination rooms; easy access to restroom facilities with a designated cubicle; additional time for sitting examinations or extended deadline to submit coursework assignments; and alternative forms of assessments will be considered without compromise to achieving learning objectives.");
*/

        listHash.put(listDataHeader.get(0), question1);
        listHash.put(listDataHeader.get(1), question2);
        listHash.put(listDataHeader.get(2), question3);
        listHash.put(listDataHeader.get(3), question4);
        listHash.put(listDataHeader.get(4), question5);
        listHash.put(listDataHeader.get(5), question6);
        listHash.put(listDataHeader.get(6), question7);
        listHash.put(listDataHeader.get(7), question8);
        listHash.put(listDataHeader.get(8), question9);
        listHash.put(listDataHeader.get(9), question10);
 /*       listHash.put(listDataHeader.get(10), question11);
        listHash.put(listDataHeader.get(11), question12);
        listHash.put(listDataHeader.get(11), question13);
        listHash.put(listDataHeader.get(13), question14);
        listHash.put(listDataHeader.get(14), question15);
        listHash.put(listDataHeader.get(15), question16);
        listHash.put(listDataHeader.get(16), question17);
        listHash.put(listDataHeader.get(17), question18);
        listHash.put(listDataHeader.get(18), question19);
        listHash.put(listDataHeader.get(19), question20);
        listHash.put(listDataHeader.get(20), question21);
        listHash.put(listDataHeader.get(21), question22);
        listHash.put(listDataHeader.get(22), question23);
        listHash.put(listDataHeader.get(23), question24);
        listHash.put(listDataHeader.get(24), question25);
        listHash.put(listDataHeader.get(25), question26);
        listHash.put(listDataHeader.get(26), question27);
        listHash.put(listDataHeader.get(27), question28);
        listHash.put(listDataHeader.get(28), question29);
        listHash.put(listDataHeader.get(29), question30);
*/
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(FaqActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        this.finish();
    }
}