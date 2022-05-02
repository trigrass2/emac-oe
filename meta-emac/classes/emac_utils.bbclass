def remove_duplicate_values(d, *bb_vals):
    list_of_values = []
    for val in bb_vals:
        list_of_values.extend(d.getVar(val).split(" "))
    removed_dup_list = list(dict.fromkeys(list_of_values))
    removed_dup_list.remove("any")
    removed_dup_list.remove("all")
    removed_dup_list.remove("noarch")
    return " ".join(removed_dup_list)