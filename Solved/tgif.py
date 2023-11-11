months = {
    "JAN": 31,
    "FEB": 28,
    "MAR": 31,
    "APR" : 30,
    "MAY" : 31,
    "JUN" : 30,
    "JUL" : 31,
    "AUG" : 31,
    "SEP": 30,
    "OCT": 31,
    "NOV": 30,
    "DEC": 31
    }

days = {
    "MON": 0, 
    "TUE": 1,
    "WED": 2,
    "THU": 3,
    "FRI": 4,
    "SAT": 5,
    "SUN": 6
}

today_day, today_month = [x for x in input().split(" ")]
today_day = int(today_day)
start_of_year = days[input()]

# add up all days from today
total_days = today_day
after_february = False
for i, month in enumerate(months):
    if month == today_month:
        break
    if month == "FEB":
        after_february = True
    total_days += months[month]
    
    
# get day of the week by using start of year
day_of_week = (start_of_year + (total_days % 7) - 1) % 7
    # (total_days % 7)-1 = day of the week subtract 1 to match start of the days (MON starts at 0)

leap_day_of_week = None
# check leap year
if after_february:
    leap_year_days = total_days + 1
    leap_day_of_week = (start_of_year + (leap_year_days % 7) - 1) % 7     
    
if after_february == False and day_of_week == 4:
    print("TGIF")
elif day_of_week == 4 or leap_day_of_week == 4:
    print("not sure")
else:
    print(":(")