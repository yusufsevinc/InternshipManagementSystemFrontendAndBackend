import {post} from "@/services/api.service";
import {BASE_URL} from "@/services/config";

export function saveAddress(data) {
    return post(BASE_URL + 'address/save-id', data,
        "Address information has been successfully saved.",
        "Address information could not be successfully saved!",
        true);
}

