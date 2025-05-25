Драгана Петкова 236027

![Screenshot 2025-05-23 020049](https://github.com/user-attachments/assets/c3dd3d85-eb34-4505-9949-77369bce0901)

Цикломатска комплексност 

се одредува според бројот на региони во графикот, во овој случај цикломатската комплексност е 9.


Тест случаи според every statement

Минимално треба да има 5 тестови.
Прв тест: checkCard(null, "1234567890123456") - во овој тест ќе се врати првиот exception("allItems list can"t be null").
Втор тест: item = ("Strawberry", 3, 100, 0.0) checkCart(item,"1234567890123456") - во овој тест успешно ќе ја врати сумата.
Трет тест: item = ("Strawberry", 3, 100, 0.2) checkCart(item,"A234567890123456") - во овој тест ќе се врати exception("Invalid character in card number!").
Четврти тест: item = ("", 3, 100, 0.2) checkCart(item,"A234567890123456") - во овој тест ќе се врати exception("Invalid item!").
Петти тест:item = ("Strawberry", 3, 100, 0.2) checkCart(item,"A23456789012") - во овој тест ќе се врати exception("Invalid card number!").


Тест случаи според критериумот Multiple Condition

if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10)

FFF checkCart(List.of(new Item("Strawberry", 1, 150, 0)), null)
FFT checkCart(List.of(new Item("Strawberry", 15, 150, 0)), null)
FTX checkCart(List.of(new Item("Strawberry", 1, 150, 0.2)), null)
TXX checkCart(List.of(new Item("Strawberry", 0, 310, 0)), null)
