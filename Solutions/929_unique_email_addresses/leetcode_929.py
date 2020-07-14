class Solution:

    def numUniqueEmails(self, emails):
        """
        :type emails: List[str]
        :rtype: int
        """
        realEmails = set()
        for email in emails:
            local, domain = email.split("@")
            if "+" in local:
                local = local[:local.index("+")]
            realEmails.add(local.replace('.', '') + '@' + domain)
        return len(realEmails)
