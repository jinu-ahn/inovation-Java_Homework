package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        transport transport = new transport();
        Bus bus = new Bus();
        Taxi taxi = new Taxi();


        while (true) {
            System.out.print("이용할 대중교통을 선택하세요 : 1. 버스 / 2. 택시 ");
            num = sc.nextInt();
            Random random = new Random();
            switch (num) {
                case 1:
                    while (true) {
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println("1. 버스 생성 , 2. 버스 정보 , 3. 상태 변경, 4. 속도 변경 , 5. 기름 변경, 6. 승객 탑승, 0. 운행 종료 ");
                        System.out.println("------------------------------------------------------------------------------------------");
                        num = sc.nextInt();
                        switch (num) {
                            case 1:
                                // HashMap Key값은 중복값이 들어가지 않아 고유번호로 들어갑니다.
                                transport.set_number(random.nextInt(10000) + 1000);
                                bus.bus_Map.put(transport.get_number(), bus.status);
                                System.out.println(transport.number + "번 버스가 생성되었습니다.");
                                break;
                            case 2:
                                if (bus.Non_Bus() == false)
                                    break;
                                else {
                                    System.out.println("운행중인 버스 정보 : " + bus.getKey(bus.bus_Map, "운행중"));
                                    System.out.println("탑승 승객 수 : " + bus.people);
                                    System.out.println("잔여 승객 수 : " + bus.residual_people());
                                    System.out.println("요금 확인 : " + bus.bus_fee());
                                    System.out.println("속도 : " + bus.speed);
                                    System.out.println("기름 : " + bus.oil);
                                    break;
                                }
                            case 3:
                                bus.Status();
                                break;
                            case 4:
                                if (bus.Non_Bus() == false)
                                    break;
                                else {
                                    System.out.print("증감할 속도를 입력하세요 : ");
                                    int ch_speed = sc.nextInt();
                                    bus.Change_Speed(ch_speed);
                                    if (bus.oil < 10) break;
                                    else
                                        System.out.println("속도가 변경되었습니다 : " + bus.speed);
                                    break;

                                }
                            case 5:
                                if (bus.Non_Bus() == false)
                                    break;
                                else {
                                    System.out.print("기름 변경 : ");
                                    int ch_oil = sc.nextInt();
                                    bus.Change_Oil(ch_oil);
                                    if (bus.oil > 0)
                                        System.out.println("남은 기름이 변경되었습니다 : " + bus.oil);
                                    else {
                                        System.out.println("남은 기름 : " + bus.oil);
                                        break;
                                    }
                                    break;
                                }

                            case 6:
                                if (bus.Non_Bus() == false)
                                    break;
                                else {
                                    System.out.print("탑승 시킬 승객 수 : ");
                                    int people = sc.nextInt();
                                    bus.Ride_people(people);
                                    break;
                                }
                        }
                        if (num == 0) {

                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("------------------------------------------------------------------------------------------");
                        System.out.println("1. 택시 생성 , 2. 승객 탑승 , 3. 택시 정보 , 4. 속도 변경 , 5. 기름 변경, 6. 요금 결제 0. EXIT");
                        System.out.println("------------------------------------------------------------------------------------------");
                        num = sc.nextInt();
                        switch (num) {
                            case 1:
                                // HashMap Key값은 중복값이 들어가지 않아 고유번호로 들어갑니다.
                                transport.set_number(random.nextInt(10000) + 1000);
                                taxi.taxi_Map.put(transport.get_number(), taxi.status);
                                System.out.println(transport.number + "번 택시가 생성되었습니다.");
                                break;
                            case 2:
                                System.out.print("택시 리스트 : ");
                                taxi.taxi_Map.forEach((key, value) -> {
                                    System.out.println(key + " : " + value + " ");
                                });

                                taxi.Ride_people();

                                break;

                            case 3:
                                if (taxi.Non_Taxi() == false)
                                    break;
                                else {
                                    System.out.println("운행중인 택시 정보 : " + bus.getKey(taxi.taxi_Map, "운행중"));
                                    System.out.println("탑승 승객 수 : " + taxi.people);
                                    System.out.println("잔여 승객 수 : " + taxi.residual_people());
                                    System.out.println("기본 요금 확인 : " + taxi.fee);
                                    System.out.println("목적지 : " + taxi.address);
                                    System.out.println("목적지까지 거리 : " + taxi.address_by_km + "KM");
                                    System.out.println("지불할 요금 : " + taxi.taxi_fee());
                                    break;
                                }
                            case 4:
                                if (taxi.Non_Taxi() == false)
                                    break;
                                else {
                                    System.out.println("현재 속도 : " + taxi.speed);
                                    System.out.print("증감할 속도를 입력하세요 : ");
                                    int ch_speed = sc.nextInt();
                                    taxi.Change_Speed(ch_speed);
                                    if (taxi.oil < 10) break;
                                    else
                                        System.out.println("속도가 변경되었습니다 : " + taxi.speed);
                                    break;
                                }
                            case 5:
                                if(taxi.Non_Taxi() == false)
                                    break;
                                else {
                                    System.out.println("현재 기름 : " + taxi.oil);
                                    System.out.print("기름 변경 : ");
                                    int ch_oil = sc.nextInt();
                                    taxi.Change_Oil(ch_oil);
                                    if (taxi.oil > 0)
                                        System.out.println("남은 기름이 변경되었습니다 : " + taxi.oil);
                                    else {
                                        System.out.println("남은 기름 : " + taxi.oil);
                                        break;
                                    }
                                    break;
                                }

                            case 6 :
                                if(taxi.Non_Taxi() == false)
                                    break;
                                else
                                    System.out.println("총 요금 : " + taxi.sum_fee());

                                break;
                        }
                        if (num == 0)
                            break;
                    }
            }
        }
    }
}
