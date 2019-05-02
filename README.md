# Patterns
Поведенческие шаблоны — шаблоны проектирования, определяющие алгоритмы и способы реализации взаимодействия 
различных объектов и классов.

Структурные шаблоны — шаблоны проектирования, в которых рассматривается вопрос
о том, как из классов и объектов образуются более крупные структуры.

Порождающие шаблоны —  Они позволяют сделать систему независимой от способа создания, композиции и 
представления объектов. Шаблон, порождающий классы, использует наследование, чтобы изменять наследуемый класс, 
а шаблон, порождающий объекты, делегирует  инстанцирование(создание экземпляра класса) другому объекту.

Software design pattern:

##### [1. Delegate](https://github.com/AlSidorenko/Patterns/tree/master/src/delegate)

##### [2. Facade](https://github.com/AlSidorenko/Patterns/tree/master/src/facade)
Facade (структурный шаблон) - Скрывает сложную систему классов приводя все вызовы к одному объекту. 
Помещает вызов нескольких сложных объектов в один объект. Простыми словами: Шаблон фасад предоставляет 
упрощенный интерфейс для сложной системы.

##### [3. Factory Method](https://github.com/AlSidorenko/Patterns/tree/master/src/factory)
Factory method (Порождающий шаблон) - Этот паттерн необходим для динамической замены одного продукта другим. 
Т.е. код уже скомпилирован, но у тебя все же есть возможность выбора любого другого продукта. 
Так же он позволят сократить время на добавление другого продукта. После добавления нового продукта 
нет необходимости изменять все связные с ним классы.

##### [4. Abstract Factory](https://github.com/AlSidorenko/Patterns/tree/master/src/abstract_factory)
Абстрактная фабрика (Порождающий шаблон) — Абстрактная фабрика предоставляет интерфейс для создания целых 
семейств объектов без указания конкретных классов. Объекты каждого семейства должны быть логически 
связаны между собой.

##### [5. Builder](https://github.com/AlSidorenko/Patterns/tree/master/src/builder)
Строитель  (порождающий шаблон)— это паттерн, который позволяет создавать объекты пошагово. 
Он полезен, когда может быть несколько видов объекта или когда необходимо множество шагов, связанных с его созданием.
Используется для создания сложного объекта с использованием простых объектов. Постепенно он создает больший 
объект от малого и простого объекта. Позволяет изменять внутреннее представление конечного продукта.

##### [6. Prototype](https://github.com/AlSidorenko/Patterns/tree/master/src/prototype)
Prototype (Порождающий шаблон)-Помогает создать дублированный объект с лучшей производительностью, 
вместо нового создается возвращаемый клон существующего объекта. Простыми словами: Прототип создает объект, 
основанный на существующем объекте при помощи клонирования.

##### [7. Composite](https://github.com/AlSidorenko/Patterns/tree/master/src/composite)
Composite (структурный шаблон) - Группирует несколько объектов в древовидную структуру используя один класс. 
Позволяет работать с несколькими классами через один объект.

##### [8. Adapter](https://github.com/AlSidorenko/Patterns/tree/master/src/adapter)
Adapter (Структурный шаблон) - Итак, паттерн Adapter используется для того, чтобы объекты с одним интерфейсом 
(контрактом) мог работать там, где необходим объект с совершенно другим интерфейсом. Адаптер выступает прослойкой 
между двумя объектами, превращая вызовы одного в вызовы понятные другому. Используя паттерн, мы можем объединить 
два несовместимых объекта. Конвертер между двумя несовместимыми объектами.

##### [9. Decorator](https://github.com/AlSidorenko/Patterns/tree/master/src/decorator)
Decorator (Структурный шаблон) - Добавляет новые функциональные возможности существующего объекта 
без привязки его структуры.

##### [10. Command](https://github.com/AlSidorenko/Patterns/tree/master/src/command)
Command (Поведенческий шаблон) - Позволяет инкапсулировать различные операции в отдельные объекты. Основная идея, 
стоящая за шаблоном — это предоставление средств, для разделения клиента и получателя.

##### [11. Chain](https://github.com/AlSidorenko/Patterns/tree/master/src/chain)

##### [12. Memento](https://github.com/AlSidorenko/Patterns/tree/master/src/memento)

##### [13. Mediator](https://github.com/AlSidorenko/Patterns/tree/master/src/mediator)
Mediator (Поведенческий шаблон) — это клей, связывающий несколько независимых классов между собой. 
Он избавляет классы от необходимости ссылаться друг на друга, позволяя тем самым их независимо 
изменять и анализировать. Обрабатывает все связи между различными классами.
Используем:
    • Когда имеется множество взаимосвязаных объектов, связи между которыми сложны и запутаны.
    • Когда необходимо повторно использовать объект, однако повторное использование затруднено в силу сильных 
      связей с другими объектами.
      
##### [14. Observer](https://github.com/AlSidorenko/Patterns/tree/master/src/observer)
Observer (Поведенческий шаблон) - Шаблон определяет зависимость между объектами, чтобы при изменении состояния 
одного из них зависимые от него узнавали об этом. Позволяет одним объектам наблюдать за действиями, 
что происходят в других объектах.

##### [15. State](https://github.com/AlSidorenko/Patterns/tree/master/src/state)

##### [16. Template Method](https://github.com/AlSidorenko/Patterns/tree/master/src/template_method)

##### [17. Strategy](https://github.com/AlSidorenko/Patterns/tree/master/src/strategy)
Strategy (Поведенческий шаблон) – Шаблон стратегия позволяет переключаться между алгоритмами или стратегиями 
в зависимости от ситуации.

##### [18. Visitor](https://github.com/AlSidorenko/Patterns/tree/master/src/visitor)
Посетитель (Поведенческий шаблон)  — это паттерн, который позволяет добавлять в программу новые операции, 
не изменяя классы объектов, над которыми эти операции могут выполняться.

##### [19. Iterator](https://github.com/AlSidorenko/Patterns/tree/master/src/iterator)
Iterator (Поведенческий шаблон) - Дословно «Iterator» можно перевести как «переборщик». То есть это некая сущность, 
способная перебрать все элементы в коллекции. При этом она позволяет это сделать без вникания во внутреннюю 
структуру и устройство коллекций.

##### [20. Proxy Surrogate](https://github.com/AlSidorenko/Patterns/tree/master/src/proxy_surrogate)
Proxy (структурный шаблон) - Простыми словами: Используя шаблон заместитель, класс отображает функциональность
другого класса.

##### [21. Flyweight](https://github.com/AlSidorenko/Patterns/tree/master/src/flyweight)
Flyweight (структурный шаблон) – Приспособленец, используется для минимизации использования памяти или 
вычислительной стоимости путем разделения ресурсов с наибольшим количеством похожих объектов. Вместо создания 
большого количества похожих объектов, объекты используются повторно. Экономит память.

##### [22. Singleton]()
Singleton (порождающий шаблон) - гарантирующий, что создаваемый объект является единственным объектом своего класса.
и в однопоточном приложении будет единственный экземпляр класса с глобальной точкой доступа. Иными словами 
ограничивает создание одного экземпляра класса, обеспечивает доступ к его единственному объекту. 
Конструктор класса приватный. Метод getInstance() создает только один экземпляр класса
Используем в случае кеширования данных и в том случае если мы хотим производить какое-либо действие при 
любом обращении к классу.