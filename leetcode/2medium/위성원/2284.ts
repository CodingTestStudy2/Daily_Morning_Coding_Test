function largestWordCount(messages: string[], senders: string[]): string {
    const map = new Map<string, number>()

    for (const sender of senders) {
        if (map.has(sender)) {
            continue;
        }

        map.set(sender, 0)
    }

    messages.forEach((message, index) => {
        const sender = senders[index];
        const words = message.split(" ");
        map.set(sender, map.get(sender) ?? 0 + words.length)
    })

    let answer = { name: "", count: -1 }
    for (const [name, count] of map) {
        if (count > answer.count || (count === answer.count && name > answer.name)) {
            answer = { name, count }
        }
    }

    return answer.name
};