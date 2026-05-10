from typing import List, Tuple


def best_student(scores: List[Tuple[str, int]]) -> str:
    high_name = ""
    high_score = -1
    for score in scores:
        name, current_score = score[0], score[1]
        if current_score > high_score:
            high_score = current_score
            high_name = name
    
    return high_name


# do not modify below this line
print(best_student([("Alice", 90), ("Bob", 80), ("Charlie", 70)]))
print(best_student([("Alice", 90), ("Bob", 80), ("Charlie", 100)]))
print(best_student([("Alice", 90), ("Bob", 100), ("Charlie", 70)]))
print(best_student([("Alice", 90), ("Bob", 90), ("Charlie", 80), ("David", 100)]))
