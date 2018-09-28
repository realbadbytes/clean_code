/* shit code
*/

for (int j = 0; j < 34; j++) {
    s += (t[j] * 4) / 5;
}

/* better code

this example allows for grepping if shit goes wrong
I would improve upon this though by declaring realTaskDays and
realTaskWeeks outside of the for loop. Thoughts? */

int scaleFactor = 4;
const int WORK_DAYS_PER_WEEK = 5;
int sum = 0;
for (int j = 0; j < NUM_TASKS; j++) {
    int realTaskDays = taskEstimate[j] * scaleFactor;
    int realTaskWeeks = (realdays / WORK_DAYS_PER_WEEK);
    sum += realTaskWeeks;
}
