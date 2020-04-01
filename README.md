# VirtualCamera
Celem projektu jest zaimplementowanie aplikacji okienkowej symulującej działanie kamery. Do zrealizowania projektu zostanie wykorzystana Java 8 wraz z biblioteką do tworzenia interfejsów graficznych – JavaFX. 
Kamera wyświetlać będzie uproszczony krajobraz miejski - ulicę wraz z przylegającymi do niej budynkami. Wyświetlony obraz będzie miał charakter rzutu perspektywicznego. 
Wczytywanie danych będzie następowało z pliku *.txt. Otrzymane dane będą umieszczane w macierzach, a następnie będą wyświetlane w odpowiednich miejscach obszaru roboczego. W dalszej kolejności nastąpi połączenie tych punktów poprzez zastosowanie rzutowania 3 wymiarowego na 2 wymiarowe. Na tak przygotowanych danych użytkownik będzie miał możliwość wykonania szeregu akcji, które będą wykonywane na podstawie odpowiednich obliczeń i transformacji.  

Zestaw akcji, które będzie mógł wykonać użytkownik w czasie działania programu: 

- Przemieszczenie kamery (względem 3 osi) 
- Obrotu kamery (względem 3 osi) 
- Zmiany ogniskowej – tzw. “zoom” 
