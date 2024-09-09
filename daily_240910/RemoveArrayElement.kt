package daily_240910

/**
 * 프로그래머스 - 배열에서 원소 제거하기
 */
class RemoveArrayElement {
    fun solution(arr: IntArray, delete_list: IntArray): IntArray {
        return arr.filter { it !in delete_list }.toIntArray()
    }
}