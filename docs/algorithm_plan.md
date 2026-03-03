parkVehicle():
Check if parking slots are available.
If vehicle is VIP → insert into heap.
Else → push vehicle into stack.
Generate slot number.
Store (vehicleNumber, slotNumber) in hash table.
Decrease available slot count.
Display assigned slot.

removeVehicle():
Search vehicleNumber in hash table.
If not found → display "Vehicle not found".
Get slot number from hash table.
Remove vehicle from stack or heap.
Delete entry from hash table.
Increase available slot count.
Display confirmation message.

searchVehicle():
Input vehicleNumber.
Check hash table for the key.
If found → retrieve slot number.
Display vehicle details and slot.
Else → display "Vehicle not parked".

displayAvailableSlots():
Get total parking capacity.
Get current occupied slots.
Calculate available slots.
Display number of available slots.
Optionally display VIP and normal slots separately.

assignPrioritySlot():
Check if VIP slots are available.
Insert vehicle into heap (priority queue).
Assign highest priority slot.
Store vehicle details in hash table.
Update available slot count.
Display assigned VIP slot.
