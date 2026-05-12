from typing import List

def find_max_in_each_list(nested_arr: List[List[int]]) -> List[int]:
    maxes = []
    for i in range(len(nested_arr)):
        list_i = nested_arr[i]
        max_of_list = list_i[0]
        for j in range(len(list_i)):
            max_of_list = max(max_of_list, list_i[j])
        
        maxes.append(max_of_list)
    
    return maxes

# def find_max_in_each_list(nested_arr: List[List[int]]) -> List[int]:
#     pass


# do not modify below this line
print(find_max_in_each_list([[1, 2], [3, 4, 2]]))
print(find_max_in_each_list([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
print(find_max_in_each_list([[5, 6, 2, 8], [9], [9, 10], [11, 10, 11]]))
