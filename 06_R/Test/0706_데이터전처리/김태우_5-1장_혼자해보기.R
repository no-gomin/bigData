# 혼자서 해보기1 : mpg 데이터를 이용해 분석 문제를 해결해 보세요.
# Q1. 자동차 배기량에 따라 고속도로 연비가 다른지 알아보려고 합니다. displ(배기량)이 4
# 이하인 자동차와 5 이상인 자동차 중 어떤 자동차의 hwy(고속도로 연비)가 평균적으로 더 높은지
# 알아보세요.
mpg1 <- mpg
head(mpg1)
mpg1 <- mpg %>% 
  mutate(displ_over = ifelse(displ >= 5, 'over', ifelse(displ <=4, 'under', 'no_data'))) %>% 
  group_by(displ_over) %>% 
  summarise(avg_hwy_over = mean(hwy))
paste('4이하 자동차가 5이상 자동차보다 ', mpg1[3,2]-mpg1[2,2], '높다')

mpg1_displ_u <- mpg[mpg$displ<=4,]
mpg1_displ_o <- mpg[mpg$displ>=5,]
head(mpg1_displ_o)
avg_displ_u <- tapply(mpg1_displ_u$hwy, mpg1_displ_u$displ<=4, FUN = mean )
avg_displ_o <- tapply(mpg1_displ_o$hwy, mpg1_displ_o$displ<=4, FUN = mean )
paste('4이하 자동차가 5이상 자동차보다 ', avg_displ_u-avg_displ_o, '높다')


# Q2. 자동차 제조 회사에 따라 도시 연비가 다른지 알아보려고 합니다. "audi"와 "toyota"
# 중 어느 manufacturer(자동차 제조 회사)의 cty(도시 연비)가 평균적으로 더 높은지
# 알아보세요.
mpg1_2 <- mpg %>% 
  filter(manufacturer %in% c('audi', 'toyota')) %>% 
  group_by(manufacturer) %>% 
  summarise(avg_cty = mean(cty)) %>% 
  arrange(-avg_cty)
mpg1_2
paste(mpg1_2[1,1],'의 도시연비가 ',mpg1_2[2,1], '보다 ',mpg1_2[1,2]-mpg1_2[2,2],' 높다')

mpg1_audi <- apply(subset(mpg, mpg$manufacturer == 'audi', select = 8), 2, FUN = mean)
mpg1_toyota <- apply(subset(mpg, mpg$manufacturer == 'toyota', select = 8), 2, FUN = mean)
paste('toyota 의 도시연비가 audi 보다 ', mpg1_toyota-mpg1_audi ,' 높다')


# • Q3. "chevrolet", "ford", "honda" 자동차의 고속도로 연비 평균을 알아보려고 합니다. 이 회사들의 자동차를 추출한 뒤 hwy 전체 평균을 구해보세요
mpg %>% 
  filter(manufacturer %in% c('chevrolet', 'ford', 'honda')) %>% 
  group_by(manufacturer) %>% 
  summarise(avg_hwy = mean(hwy))

mpg1_3 <- subset(mpg, mpg$manufacturer %in% c('chevrolet', 'ford', 'honda'), )
tapply(mpg1_3[,'hwy'], mpg1_3$manufacturer, FUN = mean)




# 혼자서 해보기 2 . mpg 데이터를 이용해서 분석 문제를 해결해보세요.
# • Q1. mpg 데이터는 11개 변수로 구성되어 있습니다. 이 중 일부만 추출해서 분석에 활용하려고 합니다. mpg 데이터에서 class(자동차 종류), cty(도시 연비) 변수를 추출해 새로운 데이터를 만드세요. 새로 만든 데이터의 일부를 출력해서 두 변수로만 구성되어 있는지 확인하세요.
mpg2 <- mpg %>% select(class, cty)
head(mpg2)

mpg2_1 <- subset(mpg, select = c(class, cty))
head(mpg2_1)

# • Q2. 자동차 종류에 따라 도시 연비가 다른지 알아보려고 합니다. 앞에서 추출한 데이터를 이용해서 class(자동차 종류)가 "suv"인 자동차와 "compact"인 자동차 중 어떤 자동차의 cty(도시 연비)가 더 높은지 알아보세요.
mpg2 %>% 
  filter(class %in% c('suv', 'compact')) %>% 
  group_by(class) %>% 
  summarise(avg_cty = mean(cty))


mpg2_2 <- tapply(mpg2_1$cty, mpg2$class, FUN = mean)
paste('compact가 suv보다 높음 : ', mpg2_2['compact'] - mpg2_2['suv'])

# • Q3. "audi"에서 생산한 자동차 중에 어떤 자동차 모델의 hwy(고속도로 연비)가 높은지 알아보려고 합니다. "audi"에서 생산한 자동차 중 hwy가 1~5위에 해당하는 자동차의 데이터를 출력하세요
mpg2_3 <- mpg
mpg2_3 %>% 
  filter(manufacturer == 'audi') %>% 
  arrange(desc(hwy)) %>% 
  head(5)

head(orderBy(~ -hwy, data = mpg2_3[mpg2_3$manufacturer == 'audi',]), 5)





# 혼자서 해보기 3. mpg 데이터를 이용해서 분석 문제를 해결해보세요.
# mpg 데이터는 연비를 나타내는 변수가 hwy(고속도로 연비), cty(도시 연비) 두 종류 로 분리되어 있습니다. 두 변수를 각각 활용하는 대신 하나의 통합 연비 변수를 만들어 분석하려고 합니다.
# • Q1. mpg 데이터 복사본을 만들고, cty와 hwy를 더한 '합산 연비 변수'를 추가하세요
mpg3 <- mpg
head(mpg3)
mpg3 <- mpg3 %>% mutate(tot_fuel = cty + hwy)  

tot_fuel <- as.data.frame(mpg$cty + mpg$hwy)
names(tot_fuel) <- 'tot_fuel'
mpg3_1 <- cbind(mpg, tot_fuel)
head(mpg3_1)

# Q2. 앞에서 만든 '합산 연비 변수'를 2로 나눠 '평균 연비 변수'를 추가세요.
mpg3 <- mpg3 %>% mutate(avg_fuel = tot_fuel / 2)  
head(mpg3)

mpg3_1 <- cbind(mpg3_1, avg_fuel = mpg3_1$tot_fuel / 2)
head(mpg3_1)

# Q3. '평균 연비 변수'가 가장 높은 자동차 3종의 데이터를 출력하세요.
mpg3 %>% 
  arrange(-avg_fuel) %>% 
  head(3)

head(mpg3_1[order(mpg3_1$avg_fuel, decreasing = TRUE),], 3)

# • Q4. 1~3번 문제를 해결할 수 있는 하나로 연결된 dplyr 구문을 만들어 출력하세요. 데이터는 복사본 대신 mpg 원본을 이용하세요
mpg3 %>% 
  mutate(tot_fuel = cty + hwy, avg_fuel = tot_fuel / 2) %>% 
  arrange(-avg_fuel) %>% 
  head(3)







# 혼자서 하기4. mpg 데이터를 이용해서 분석 문제를 해결해 보세요.
# • Q1. mpg 데이터의 class는 "suv"
# , "compact" 등 자동차를 특징에 따라
# 일곱 종류로 분류한 변수입니다. 어떤 차종의 연비가 높은지 비교해보려고 합니다. 
# class별 cty 평균을 구해보세요.
mpg4 <- mpg
head(mpg4)
str(mpg4$class)
mpg4 %>% 
  group_by(class) %>% 
  summarise(avg_cty = mean(cty))
# • Q2. 앞 문제의 출력 결과는 class 값 알파벳 순으로 정렬되어 있습니다. 어떤
# 차종의 도시 연비가 높은지 쉽게 알아볼 수 있도록 cty 평균이 높은 순으로
# 정렬해 출력하세요.
mpg4 %>% 
  group_by(class) %>% 
  summarise(avg_cty = mean(cty)) %>% 
  arrange(desc(avg_cty))
# • Q3. 어떤 회사 자동차의 hwy(고속도로 연비)가 가장 높은지 알아보려고 합니다. 
# hwy 평균이 가장 높은 회사 세 곳을 출력하세요.
mpg4 %>% 
  group_by(manufacturer ) %>% 
  summarise(avg_hwy = mean(hwy)) %>% 
  arrange(-avg_hwy) %>% 
  head(3)
# • Q4. 어떤 회사에서 "compact"(경차) 차종을 가장 많이 생산하는지 알아보려고
# 합니다. 각 회사별 "compact" 차종 수를 내림차순으로 정렬해 출력하세요.
mpg4 %>% 
  group_by(manufacturer) %>% 
  filter(class == 'compact') %>% 
  summarise(cnt = n()) %>% 
  arrange(desc(cnt))




#################    혼자 해보기 (5)    #################
data(mpg, package = 'ggplot2')
mpg$fl
dim(mpg)
fuel <- data.frame(fl = c('c','d','e','p','r'),
                   kind = c('cng','diesel','ethanol E85','premium','regular'),
                   price_fl = c(2.35, 2.38, 2.11, 2.76, 2.22))
fuel # 5행 3열
# Q1. mpg에 price_fl 변수 추가
mpg <- left_join(mpg, fuel[, c('fl', 'price_fl')], by = 'fl')
mpg <- merge(mpg, fuel[, c('fl', 'price_fl')], by = 'fl')

# Q2. model, fl, price_fl 앞5행 추출
mpg %>% 
  select(model, fl, price_fl) %>% 
  head(5)
mpg[1:5, c('model', 'fl', 'price_fl')]
subset(mpg, select=c('model', 'fl', 'price_fl'))[1:5,]
head(subset(mpg, select = c('model', 'fl', 'price_fl')), 5)

# Q3. mpg에 kind 변수도 추가
fuel[, c('fl', 'kind')]
mpg <- merge(mpg, fuel[, c('fl', 'kind')], by = 'fl')
mpg <- left_join(mpg, fuel[, c('fl', 'kind')], by = 'fl')

##### left_join을 쓰지 않고 apply을 이용하여 kind 변수 추가
data(mpg, package = 'ggplot2') # 데이터 다시 가져옴
fuel[fuel$fl == 'p','kind']

flToKind <- function(fl){
  kind <- fuel[fuel$fl == fl,'kind']  
  return(kind)
}
flToKind('r')

mpg$kind <- apply(mpg[, 'fl', drop = FALSE], 1, flToKind)
head(mpg)





########################
#### 혼자해보기 (6) ####
########################

data(mpg, package = 'ggplot2')
mpg <- as.data.frame(ggplot2::mpg)

mpg[c(10, 14, 58, 93), "drv"] <- "k" # drv 이상치 할당
mpg[c(29, 43, 129, 203), "cty"] <- c(3, 4, 39, 42) # cty 이상치 할당


# Q1. drv에 이상치가 있는지 확인하세요. 이상치를 결측 처리한 다음 이상치가 사라졌는지 확인하세요. 결측 처리 할 때는 %in% 기호를 활용하세요.
table(mpg$drv)
mpg$drv <- ifelse(mpg$drv %in% c(4, 'f', 'r'), mpg$drv, NA)
table(mpg$drv)
sum(is.na(mpg$drv))

# • Q2. 상자 그림을 이용해서 cty에 이상치가 있는지 확인하세요. 상자 그림의 통계치를 이용해 정상 범위를 벗어난 값을 결측 처리한 후 다시 상자 그림을 만들어 이상치가 사라졌는지 확인하세요.
boxplot(mpg$cty)
result <- boxplot(mpg$cty)$stats
mpg$cty <- ifelse(mpg$cty > result[5] | mpg$cty < result[1], NA, mpg$cty)
boxplot(mpg$cty)

# • Q3. 두 변수의 이상치를 결측처리 했으니 이제 분석할 차례입니다. 이상 치를 제외한 다음 drv별로 cty 평균이 어떻게 다른지 알아보세요. 하나의 dplyr 구문으로 만들어야 합니다.
mpg %>% 
  filter(!is.na(drv) & !is.na(cty)) %>% 
  group_by(drv) %>% 
  summarise(mean(cty))

tapply(mpg$cty, mpg$drv, FUN = mean, na.rm = T)





