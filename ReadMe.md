#Story 1
# [x] Case 1  
>   **GIVEN** a parking lot, and a car  
    **WHEN** park the car  
    **THEN** return a parking ticket
# [x] Case 2
>   **GIVEN** a parking lot with parked car, and a ticket  
    **WHEN** fetch the car  
    **THEN** return the parked car
 # [x] Case 3
>   **GIVEN** a parking lot with two parked cars, and a two parking tickets   
    **WHEN** fetch the car twice  
    **THEN** return the right car with each ticket
 # [x] Case 4
>   **GIVEN** a parking lot, and a wrong parking ticket   
    **WHEN** fetch the car  
    **THEN** return nothing
# [x] Case 5
>   **GIVEN** a parking lot, and a used parking ticket  
    **WHEN** fetch the car  
    **THEN** return nothing
# [x] Case 6
>   **GIVEN** a parking lot without any position, and a car  
    **WHEN** park the car  
    **THEN** return nothing

#Story 2
# [x] Case 1
>   **GIVEN** a parking lot, and an unrecognized ticket  
    **WHEN** fetch the car  
    **THEN** return nothing with error message "Unrecognized parking ticket."  

# [x] Case 2
>   **GIVEN** a parking lot, and a used ticket  
    **WHEN** fetch the car    
    **THEN** return nothing with error message "Unrecognized parking ticket."

# [x] Case 3
>   **GIVEN** a parking lot without any position, and a car   
    **WHEN** park the car  
    **THEN** return nothing with error message "No available position."
   
#Story 3
# [x] Case 1
>   **GIVEN** a parking lot, a standard parking boy, and a car   
    **WHEN** park the car   
    **THEN** return a parking ticket  
> 
# [x] Case 2
>   **GIVEN** a parking lot with a parked car, a standard parking boy, and a parking ticket    
    **WHEN** fetch the car  
    **THEN** return a parked car

# [x] Case 3
>   **GIVEN** a parking lot with two parked cars, a standard parking boy, and two parking tickets  
    **WHEN** fetch the car twice
    **THEN** return the right car with each ticket

# [x] Case 4
>   **GIVEN** a parking lot, a standard parking boy, and a wrong parking ticket  
    **WHEN** fetch the car  
    **THEN** return nothing with error message "Unrecognized parking ticket."

# [x] Case 5
>   **GIVEN** a parking lot, a standard parking boy, and a used parking ticket  
    **WHEN** fetch the car  
    **THEN** return nothing with error message "Unrecognized parking ticket."

# [x] Case 6
>   **GIVEN** a parking lot without any position, a standard parking boy, and a car  
    **WHEN** park the car  
    **THEN** return nothing with error message "Unrecognized parking ticket."

# Story 4
# [x] Case 1
>   **GIVEN** a standard parking boy, who manage two parking lots, both with available position, and a car  
    **WHEN** park the car  
    **THEN** return car parked to the first lot

# [x] Case 2
>   **GIVEN** a standard parking boy, who manage two parking lots, first is full and second with available position, and a car  
    **WHEN** park the car  
    **THEN** return car parked to the second lot

# [x] Case 3
>   **GIVEN** a standard parking boy, who manage two parking lots, both wirh parked car, and two parking ticket  
    **WHEN** fetch the car twice  
    **THEN** return right car with each ticket

 # [x] Case 4
>   **GIVEN** a standard parking boy, who manage two parking lots, and unrecognized parking ticket  
    **WHEN** fetch the car twice  
    **THEN** return nothing with error message "Unrecognized parking ticket."

# [x] Case 5
>   **GIVEN** a standard parking boy, who manage two parking lots, and a used parking ticket  
    **WHEN** fetch the car twice  
    **THEN** return nothing with error message "Unrecognized parking ticket."

# [x] Case 6
>   **GIVEN** a standard parking boy, who manage two parking lots, both without any position  
    **WHEN** park the car  
    **THEN** return nothing with error message "No available position."  

#Story 5
# [x] Case 1
>   **GIVEN** a smart parking boy, a parking lot, and a car  
    **WHEN** park the car  
    **THEN** return parking ticket
> 
# [x] Case 2
>   **GIVEN** a smart parking boy, a parking lot with parked car, and a ticket  
    **WHEN** fetch the car  
    **THEN** return the parked car
> 
# [x] Case 3
>   **GIVEN** a smart parking boy, a parking lot with two parked cars, and a two parking tickets  
    **WHEN** fetch the car twice  
    **THEN** return the right car with each ticket
> 
# [x] Case 4
>   **GIVEN** a smart parking boy,  a parking lot, and a wrong parking ticket   
    **WHEN** fetch the car  
    **THEN** return nothing
> 
# [x] Case 5
>   **GIVEN** a smart parking boy, a parking lot, and a used parking ticket  
    **WHEN** fetch the car  
    **THEN** return nothing
# [x] Case 6
>   **GIVEN** a smart parking boy, a parking lot without any position, and a car  
    **WHEN** park the car  
    **THEN** return nothing

# [x] Case 7
>   **GIVEN** a smart parking boy, 2 available parking lots, and a car  
    **WHEN** park the car  
    **THEN** return car from parking 1

# [x] Case 8
>   **GIVEN** a smart parking boy, 2 parking lot where parking lot 1 has more space, and a car  
    **WHEN** park the car  
    **THEN** return car from parking 1

# [x] Case 9
>   **GIVEN** a smart parking boy, 2 parking lot where parking lot 2 has more space, and a car  
    **WHEN** park the car  
    **THEN** return car from parking 2

# [x] Case 10
>   **GIVEN** a smart parking boy, 2 parking lot both with parked cars, and 2 tickets  
    **WHEN** fetch the car  
    **THEN** return right car with each ticket

# [x] Case 11
>   **GIVEN** a smart parking boy, who manage two parking lots, and unrecognized parking ticket  
    **WHEN** fetch the car twice  
    **THEN** return nothing with error message "Unrecognized parking ticket."

# [x] Case 12
>   **GIVEN** a smart parking boy, who manage two parking lots, and a used parking ticket  
    **WHEN** fetch the car twice  
    **THEN** return nothing with error message "Unrecognized parking ticket."

# [x] Case 13
>   **GIVEN** a smart parking boy, who manage two parking lots, both without any position  
    **WHEN** park the car  
    **THEN** return nothing with error message "No available position."

