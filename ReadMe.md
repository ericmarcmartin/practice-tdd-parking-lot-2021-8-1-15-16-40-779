#Story 1
# [ ] Case 1  
>   **GIVEN** a parking lot, and a car  
    **WHEN** park the car  
    **THEN** return a parking ticket
# [ ] Case 2
>   **GIVEN** a parking lot with parked car, and a ticket
    **WHEN** fetch the car
    **THEN** return the parked car
 # [ ] Case 3
>   **GIVEN** a parking lot with two parked cars, and a two parking tickets  
    **WHEN** fetch the car twice
    **THEN** return the right car with each ticket
 # [ ] Case 4
>   **GIVEN** a parking lot, and a wring parking ticket  
    **WHEN** fetch the car
    **THEN** return nothing
# [ ] Case 5
>   **GIVEN** a parking lot, and a used parking ticket
    **WHEN** fetch the car
    **THEN** return nothing
# [ ] Case 6
>   **GIVEN** a parking lot without any position, and a car
    **WHEN** fetch the car
    **THEN** return nothing
