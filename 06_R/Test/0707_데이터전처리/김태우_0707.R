flightDF <- read.csv('inData/flights14.csv', header = T)
dim(flightDF)
edit(flightDF)
head(flightDF, 2)
tail(flightDF, 2)

install.packages('data.table')
library('data.table')
flights <- fread('inData/flights14.csv') # 
head(flights)


library(dplyr)
library(doBy)


# 1. origin이 JFK이고 month가 5월인 모든 행을 resul에 얻는다
resul <- flightDF[flightDF$origin == 'JFK' & flightDF$month == 5, ]
edit(resul)


# 2. 처음 두 행을 resul에 얻는다
resul <- head(flightDF, 2)
head(resul)


# 3. origin으로 오름차순, dest로 내림차순으로 정렬하여 출력
flightDF[order(flightDF$origin, desc(flightDF$dest)), ]


# 4. arr_delay열만 출력
flightDF[, 'arr_delay']


# 5. year열부터 dep_time열까지 출력
flightDF[, 1:4]


# 6. year열과 dep_time열 출력
flightDF[, c(1, 4)]


# 7. arr_delay열과 dep_delay열을 출력하되 열이름을 delay_arr과 delay_dep로 변경
flightDF %>% 
  mutate(delay_arr = arr_delay, delay_dep = dep_delay) %>% 
  select(delay_arr, delay_dep)

temp7 <- flightDF[, c("arr_delay", "dep_delay")]
colnames(temp7) <- c('delay_arr', 'delay_dep')
head(temp7)


# 8. 지연시간(arr_delay, dep_delay모두 0미만인 비행이 몇 번인지 출력
flightDF %>% 
  filter(arr_delay < 0 & dep_delay < 0) %>% 
  summarise(n())

nrow(subset(flightDF, flightDF$arr_delay < 0 & flightDF$dep_delay < 0))


# 8-1 지연시간의 합이 0미만인 비행이 몇 번인지 출력
flightDF %>% 
  filter(arr_delay + dep_delay < 0) %>% 
  summarise(n())

nrow(subset(flightDF, flightDF$arr_delay + flightDF$dep_delay < 0))


# 9. 6월에 출발 공항이 JFK인 모든 항공편의 도착지연 및 출발지연 시간의 평균을 계산
flightDF %>% 
  filter(month == '6', origin == 'JFK') %>% 
  summarise(mean(arr_delay), mean(dep_delay))

temp9 <- flightDF[flightDF$month == 6 & flightDF$origin == 'JFK', c("arr_delay", "dep_delay")]
apply(temp9, 2, mean)


# 10. 9번의 결과에 title에 mean_arr, mean_dep로 출력
flightDF %>% 
  filter(month == '6', origin == 'JFK') %>% 
  summarise(mean_arr = mean(arr_delay), mean_dep = mean(dep_delay))

temp9 <- flightDF[flightDF$month == 6 & flightDF$origin == 'JFK', c("arr_delay", "dep_delay")]
names(temp9) <- c('mean_arr', 'mean(dep')
apply(temp9, 2, mean)


# 11. JFK 공항의 6월 운항 횟수
flightDF %>% 
  filter(month == 6, origin == 'JFK') %>% 
  summarise(cnt = n())

NROW(subset(flightDF, flightDF$month == 6 & flightDF$origin == "JFK"))


# 12. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 출력
flightDF %>% 
  filter(month == 6) %>% 
  select(arr_delay, dep_delay)

subset(flightDF, flightDF$month == 6 & flightDF$origin == "JFK", select = c("arr_delay", "dep_delay"))


# 13. JFK 공항의 6월 운항 데이터 중 arr_delay열과 dep_delay열을 제외한 모든 열 출력
flightDF %>% 
  filter(month == 6) %>% 
  select(-arr_delay, -dep_delay)

subset(flightDF, flightDF$month == 6 & flightDF$origin == "JFK", select = c(-7, -5))


# 14. 출발 공항(origin)별 비행 수 출력 (JFK 81483 LGA 84433 EWR 87400)
flightDF %>% 
  group_by(origin) %>% 
  summarise(n())

tapply(flightDF$origin, FUN = table, flightDF$origin)


# 15. 항공사코드(carrier)가 AA에 대해 출발공항별 비행횟수 계산
flightDF %>% 
  filter(carrier == 'AA') %>% 
  group_by(origin) %>% 
  summarise(n())

temp15 <- flightDF[flightDF$carrier == 'AA', ]
tapply(temp15$origin, FUN = table, temp15$origin)


# 16. origin, dest별로 비행횟수 출력
flightDF %>% 
  group_by(origin, dest) %>% 
  summarise(n())

tapply(flightDF$dest, FUN = table, flightDF$origin)


# 17. 항공사코드(carrier)가 AA에 대해 origin, dest별로 비행횟수 출력
flightDF %>% 
  filter(carrier == 'AA') %>% 
  group_by(origin, dest) %>% 
  summarise(n())

temp17 <- flightDF[flightDF$carrier == 'AA', ]
tapply(temp17$dest, FUN = table, temp17$origin)


# 18. 항공사 코드가 AA에 대해, origin, dest, 월별 평균arr_delay, 평균 dep_delay 출력
flightDF %>% 
  filter(carrier == 'AA') %>% 
  group_by(origin, dest, month) %>% 
  summarise(mean_arr_delay = mean(arr_delay), mean_dep_delay = mean(dep_delay))

temp18 <- flightDF[flightDF$carrier == 'AA', ]
aggregate(temp18[, c("arr_delay", "dep_delay")], by = list(temp18$origin, temp18$dest, temp18$month), FUN = mean)


# 19. dep_delay>0가 참이거나 거짓, arr_delay>0가 참이거나 거짓인 각각의 비행횟수
flightDF %>% 
  mutate(dep_TR = ifelse(dep_delay>0, TRUE, FALSE), 
         arr_TR = ifelse(arr_delay>0, TRUE, FALSE)) %>% 
  group_by(dep_TR, arr_TR) %>% 
  summarise(n())

temp19_1 <- ifelse(flightDF$dep_delay>0, 'dep_true', 'dep_false')
temp19_2 <- ifelse(flightDF$arr_delay>0, 'arr_true', 'arr_false')
aggregate(c(temp19_1, temp19_2), by = list(temp19_1, temp19_2), FUN = summary) ######## 오류!!


# 20. Origin==“JFK”에 대해 월별 최대 출발 지연 시간 출력(month로 정렬)
flightDF %>% 
  filter(origin == "JFK") %>% 
  group_by(month) %>% 
  summarise(max(dep_delay))

temp20 <- flightDF[flightDF$origin == 'JFK', ]
aggregate(temp20[, 'dep_delay'], by = list(temp20$month), FUN = max)


