/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
 class Solution {
    public:
        ListNode* deleteSpecificNum(ListNode* head, int target)
        {
            ListNode dummy;
            dummy.next = head;
    
            ListNode* prev = &dummy;
            ListNode* curr = head;
    
            while (curr)
            {
                if (curr->val == target)
                {
                    prev->next = curr->next;
                    curr = prev->next;
                }
                else
                {
                    prev = curr;
                    curr = curr->next;
                }
            }
            return dummy.next;
        }
    
    
        ListNode* deleteDuplicates(ListNode* head) {
            unordered_map<int, int> dupMap;
            ListNode* output = head;
            ListNode* currIndex = head;
    
            while (currIndex)
            {
                dupMap[currIndex->val]++;
                currIndex = currIndex->next;
            }
    
            for (auto p : dupMap)
            {
                if (p.second > 1)
                {
                    output = deleteSpecificNum(output, p.first);
                }
            }
            return output;
        }
    };