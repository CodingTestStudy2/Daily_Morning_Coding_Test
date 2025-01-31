const DAYS_OF_MONTHS = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

function countDaysTogether(arriveAlice: string, leaveAlice: string, arriveBob: string, leaveBob: string): number {
    const getConvertedDays = (date: string) => {
        const split = date.split("-");
        const [month, day] = split

        let days = Number(day);
        for (let i = 0; i < (Number(month) - 1); i++) {
            days += DAYS_OF_MONTHS[i];
        }

        return days
    }

    const arriveAliceDays = getConvertedDays(arriveAlice)
    const leaveAliceDays = getConvertedDays(leaveAlice)
    const arriveBobDays = getConvertedDays(arriveBob)
    const leaveBobDays = getConvertedDays(leaveBob)

    if (arriveBobDays >= arriveAliceDays) {
        if (leaveAliceDays >= arriveBobDays) {
            return Math.min(leaveAliceDays, leaveBobDays) - arriveBobDays + 1;
        } else {
            return 0;
        }
    } else {
        if (leaveBobDays >= arriveAliceDays) {
            return Math.min(leaveBobDays, leaveAliceDays) - arriveAliceDays + 1
        } else {
            return 0
        }
    }

    return 0
};