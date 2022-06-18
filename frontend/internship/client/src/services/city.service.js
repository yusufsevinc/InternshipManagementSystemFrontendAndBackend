import {get} from "@/services/api.service";
import {BASE_URL} from "@/services/config";

export function cityAll() {
    return get(BASE_URL + 'city/all');
}
